import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:dio/dio.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';
import '../../../core/network/api_client.dart';

class AuthState {
  final Map<String, dynamic>? user;
  final String? accessToken;
  final bool loading;
  final String? error;

  const AuthState({
    this.user,
    this.accessToken,
    this.loading = false,
    this.error,
  });

  // ⭐️ 로그인 여부 편리하게 체크하기 위한 getter
  bool get isAuthenticated => accessToken != null && accessToken!.isNotEmpty;
}

class AuthNotifier extends Notifier<AuthState> {
  late final Dio _dio;
  final _storage = const FlutterSecureStorage();

  @override
  AuthState build() {
    _initDio();
    // 앱 시작 시 저장된 토큰이 있는지 확인
    Future.microtask(() => checkAuthStatus());
    return const AuthState();
  }

  void _initDio() {
    _dio = Dio(BaseOptions(
      baseUrl: ApiClient.getBaseUrl(),
      headers: {'Content-Type': 'application/json'},
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
          final success = await _refreshAccessToken();
          if (success) {
            final token = await _storage.read(key: 'accessToken');
            e.requestOptions.headers['Authorization'] = 'Bearer $token';
            final clonedRequest = await _dio.fetch(e.requestOptions);
            return handler.resolve(clonedRequest);
          }
        }
        return handler.next(e);
      },
    ));
  }

  // 앱 켤 때 자동 로그인 상태 복원
  Future<void> checkAuthStatus() async {
    final token = await _storage.read(key: 'accessToken');
    if (token != null && token.isNotEmpty) {
      // 필요시 /auth/me 등으로 사용자 정보를 받아올 수 있음
      state = AuthState(
        user: state.user ?? {'id': '1'}, // 기본 세션 유지
        accessToken: token,
        loading: false,
        error: null,
      );
    }
  }

  Future<bool> _refreshAccessToken() async {
    try {
      final response = await _dio.post('/auth/refresh');
      final newAccessToken = response.data['accessToken'];
      if (newAccessToken != null) {
        await _storage.write(key: 'accessToken', value: newAccessToken);
        state = AuthState(
          user: state.user,
          accessToken: newAccessToken,
          loading: state.loading,
          error: state.error,
        );
        return true;
      }
    } catch (_) {
      await logout();
    }
    return false;
  }

  // 로그인
  Future<bool> login(Map<String, dynamic> credentials) async {
    state = AuthState(
      user: state.user,
      accessToken: state.accessToken,
      loading: true,
      error: null,
    );

    try {
      final response = await _dio.post('/auth/login', data: credentials);
      final accessToken = response.data['accessToken'];
      final user = response.data['user'];

      if (user != null && accessToken != null) {
        await _storage.write(key: 'accessToken', value: accessToken);
        state = AuthState(
          user: user,
          accessToken: accessToken,
          loading: false,
          error: null,
        );
        return true;
      } else {
        state = AuthState(
          user: state.user,
          accessToken: state.accessToken,
          loading: false,
          error: '아이디 또는 비밀번호가 올바르지 않습니다.',
        );
        return false;
      }
    } catch (err) {
      state = AuthState(
        user: state.user,
        accessToken: state.accessToken,
        loading: false,
        error: '로그인 실패: ${err.toString()}',
      );
      return false;
    }
  }

  // ⭐️ 로그아웃
  Future<void> logout() async {
    try {
      await _dio.post('/auth/logout');
    } catch (_) {}
    await _storage.delete(key: 'accessToken');
    state = const AuthState();
  }

  // 회원가입
  Future<bool> signup(Map<String, dynamic> data) async {
    state = AuthState(
      user: state.user,
      accessToken: state.accessToken,
      loading: true,
      error: null,
    );

    try {
      final formData = FormData.fromMap({
        'email': data['email'],
        'password': data['password'],
        'nickname': data['nickname'],
      });

      await _dio.post(
        '/auth/signup',
        data: formData,
        options: Options(headers: {'Content-Type': 'multipart/form-data'}),
      );

      state = AuthState(
        user: state.user,
        accessToken: state.accessToken,
        loading: false,
        error: null,
      );
      return true;
    } catch (err) {
      state = AuthState(
        user: state.user,
        accessToken: state.accessToken,
        loading: false,
        error: '회원가입 실패: ${err.toString()}',
      );
      return false;
    }
  }

  Future<bool> checkEmailDuplicate(String email) async {
    try {
      final response = await _dio.get('/auth/check-email', queryParameters: {'email': email});
      return response.data;
    } catch (e) {
      return false;
    }
  }

  Future<bool> checkNicknameDuplicate(String nickname) async {
    try {
      final response = await _dio.get('/auth/check-nickname', queryParameters: {'nickname': nickname});
      return response.data;
    } catch (e) {
      return false;
    }
  }
}

final authProvider = NotifierProvider<AuthNotifier, AuthState>(() {
  return AuthNotifier();
});