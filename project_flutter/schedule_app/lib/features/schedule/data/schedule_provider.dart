import 'package:dio/dio.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';
import '../../../core/network/api_client.dart';

class ScheduleState {
  final List<dynamic> schedules;
  final bool loading;
  final String? error;

  const ScheduleState({
    this.schedules = const [],
    this.loading = false,
    this.error,
  });
}

class ScheduleNotifier extends Notifier<ScheduleState> {
  late final Dio _dio;
  final _storage = const FlutterSecureStorage();

  @override
  ScheduleState build() {
    _initDio();
    return const ScheduleState();
  }

  void _initDio() {
    String baseUrl = ApiClient.getBaseUrl();
    if (baseUrl.endsWith('/')) {
      baseUrl = baseUrl.substring(0, baseUrl.length - 1);
    }

    _dio = Dio(BaseOptions(
      baseUrl: baseUrl,
      connectTimeout: const Duration(seconds: 5),
      receiveTimeout: const Duration(seconds: 5),
    ));

    _dio.interceptors.add(InterceptorsWrapper(
      onRequest: (options, handler) async {
        final token = await _storage.read(key: 'accessToken');
        if (token != null) {
          options.headers['Authorization'] = 'Bearer $token';
        }
        return handler.next(options);
      },
      onError: (DioException e, handler) async {
        if (e.response?.statusCode == 401) {
          final refreshed = await _refreshAccessToken();
          if (refreshed) {
            final newToken = await _storage.read(key: 'accessToken');
            e.requestOptions.headers['Authorization'] = 'Bearer $newToken';
            try {
              final cloned = await _dio.fetch(e.requestOptions);
              return handler.resolve(cloned);
            } catch (retryErr) {
              return handler.next(e);
            }
          }
        }
        return handler.next(e);
      },
    ));
  }

  Future<bool> _refreshAccessToken() async {
    try {
      String baseUrl = ApiClient.getBaseUrl();
      if (baseUrl.endsWith('/')) {
        baseUrl = baseUrl.substring(0, baseUrl.length - 1);
      }
      final refreshDio = Dio(BaseOptions(baseUrl: baseUrl));
      final response = await refreshDio.post('/auth/refresh');
      final newAccessToken = response.data['accessToken'];
      if (newAccessToken != null) {
        await _storage.write(key: 'accessToken', value: newAccessToken);
        return true;
      }
      return false;
    } catch (err) {
      return false;
    }
  }

  // 1. 일정 목록 조회
  Future<void> fetchSchedules({String? userId}) async {
    state = ScheduleState(schedules: state.schedules, loading: true, error: null);
    try {
      final bool hasValidUserId = userId != null && userId.trim().isNotEmpty;
      final queryParams = hasValidUserId ? {'userId': userId.trim()} : null;

      final response = await _dio.get(
        '/api/schedules',
        queryParameters: queryParams,
      );

      final List<dynamic> fetched = response.data is List ? response.data : [];
      state = ScheduleState(schedules: fetched, loading: false, error: null);
    } catch (err) {
      state = ScheduleState(
        schedules: state.schedules,
        loading: false,
        error: '일정 조회 실패: ${err.toString()}',
      );
    }
  }

  // 2. 새 일정 생성
  Future<bool> createSchedule({
    required String userId,
    required String title,
    String? description,
    DateTime? dueDate,
  }) async {
    try {
      final Map<String, dynamic> data = {
        'userId': userId,
        'title': title,
        'description': description ?? '',
        if (dueDate != null) 'dueDate': dueDate.toIso8601String(),
      };

      await _dio.post('/api/schedules', data: data);
      await fetchSchedules(userId: userId);
      return true;
    } catch (e) {
      return false;
    }
  }

  // 3. 완료 상태 토글
  Future<bool> toggleComplete(int id, {String? userId}) async {
    try {
      await _dio.patch('/api/schedules/$id/toggle');
      await fetchSchedules(userId: userId);
      return true;
    } catch (e) {
      return false;
    }
  }

  // 4. 일정 삭제
  Future<bool> deleteSchedule(int id, {String? userId}) async {
    try {
      await _dio.delete('/api/schedules/$id');
      await fetchSchedules(userId: userId);
      return true;
    } catch (e) {
      return false;
    }
  }

  // 5. 일정 내용(제목, 설명, 마감일) 수정
  Future<bool> updateSchedule({
    required int id,
    required String userId,
    required String title,
    String? description,
    DateTime? dueDate,
  }) async {
    try {
      final Map<String, dynamic> data = {
        'title': title,
        'description': description ?? '',
        if (dueDate != null) 'dueDate': dueDate.toIso8601String(),
      };

      await _dio.put('/api/schedules/$id', data: data);
      await fetchSchedules(userId: userId);
      return true;
    } catch (e) {
      return false;
    }
  }
}

final scheduleProvider = NotifierProvider<ScheduleNotifier, ScheduleState>(() {
  return ScheduleNotifier();
});