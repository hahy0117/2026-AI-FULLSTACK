import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:intl/intl.dart';
import 'package:table_calendar/table_calendar.dart';
import 'package:schedule_app/features/auth/data/auth_provider.dart';
import 'package:schedule_app/features/auth/presentation/login_page.dart';
import '../data/schedule_provider.dart';
import 'schedule_write_page.dart';

class ScheduleListPage extends ConsumerStatefulWidget {
  const ScheduleListPage({super.key});

  @override
  ConsumerState<ScheduleListPage> createState() => _ScheduleListPageState();
}

class _ScheduleListPageState extends ConsumerState<ScheduleListPage> {
  DateTime _focusedDay = DateTime.now();
  DateTime _selectedDay = DateTime.now();
  CalendarFormat _calendarFormat = CalendarFormat.month;

  @override
  void initState() {
    super.initState();
    Future.microtask(() {
      final user = ref.read(authProvider).user;
      final userId = user?['id']?.toString() ?? user?['userId']?.toString() ?? '';
      if (userId.isNotEmpty) {
        ref.read(scheduleProvider.notifier).fetchSchedules(userId: userId);
      }
    });
  }

  List<dynamic> _getEventsForDay(DateTime day, List<dynamic> schedules) {
    return schedules.where((item) {
      final dueDateStr = item['dueDate']?.toString();
      if (dueDateStr == null || dueDateStr.isEmpty) return false;
      try {
        final itemDate = DateTime.parse(dueDateStr);
        return isSameDay(itemDate, day);
      } catch (_) {
        return false;
      }
    }).toList();
  }

  void _showLogoutDialog(BuildContext context) {
    showDialog(
      context: context,
      builder: (dialogContext) => AlertDialog(
        backgroundColor: Colors.white,
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(16)),
        title: const Text(
          '로그아웃',
          style: TextStyle(fontSize: 17, fontWeight: FontWeight.w700, color: Color(0xFF191F28)),
        ),
        content: const Text(
          '로그아웃 하시겠습니까?',
          style: TextStyle(fontSize: 14, color: Color(0xFF4E5968)),
        ),
        actionsPadding: const EdgeInsets.symmetric(horizontal: 16, vertical: 12),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(dialogContext),
            child: const Text('취소', style: TextStyle(color: Color(0xFF8B95A1), fontWeight: FontWeight.w600)),
          ),
          ElevatedButton(
            style: ElevatedButton.styleFrom(
              backgroundColor: const Color(0xFFFFECEC),
              foregroundColor: const Color(0xFFE53935),
              elevation: 0,
              shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(8)),
            ),
            onPressed: () async {
              Navigator.pop(dialogContext);
              await ref.read(authProvider.notifier).logout();
              if (mounted) {
                Navigator.pushAndRemoveUntil(
                  context,
                  MaterialPageRoute(builder: (context) => const LoginPage()),
                  (route) => false,
                );
              }
            },
            child: const Text('로그아웃', style: TextStyle(fontWeight: FontWeight.w700)),
          ),
        ],
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    final state = ref.watch(scheduleProvider);
    final user = ref.watch(authProvider).user;
    final currentUserId = user?['id']?.toString() ?? user?['userId']?.toString() ?? '';

    final selectedDayEvents = _getEventsForDay(_selectedDay, state.schedules);
    final pendingCount = selectedDayEvents.where((e) => e['completed'] != true).length;

    return Scaffold(
      backgroundColor: const Color(0xFFF8F9FA),
      appBar: AppBar(
        titleSpacing: 20,
        title: Text(
          '${user?['nickname'] ?? '사용자'}의 캘린더',
          style: const TextStyle(fontSize: 19, fontWeight: FontWeight.w700, color: Color(0xFF191F28)),
        ),
        actions: [
          TextButton.icon(
            onPressed: () {
              setState(() {
                _focusedDay = DateTime.now();
                _selectedDay = DateTime.now();
              });
            },
            icon: const Icon(Icons.today_rounded, size: 16, color: Color(0xFF3182F6)),
            label: const Text('오늘', style: TextStyle(color: Color(0xFF3182F6), fontWeight: FontWeight.w600, fontSize: 13)),
          ),
          IconButton(
            tooltip: '로그아웃',
            icon: const Icon(Icons.logout_rounded, color: Color(0xFF8B95A1), size: 20),
            onPressed: () => _showLogoutDialog(context),
          ),
          const SizedBox(width: 8),
        ],
      ),
      body: state.loading && state.schedules.isEmpty
          ? const Center(child: CircularProgressIndicator(color: Color(0xFF3182F6), strokeWidth: 2))
          : Column(
              children: [
                // 달력 컨테이너 (정돈된 카드 레이아웃)
                Container(
                  margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
                  padding: const EdgeInsets.fromLTRB(8, 6, 8, 12),
                  decoration: BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.circular(16),
                    border: Border.all(color: const Color(0xFFE5E8EB)),
                  ),
                  child: TableCalendar(
                    locale: 'ko_KR',
                    firstDay: DateTime(2020, 1, 1),
                    lastDay: DateTime(2035, 12, 31),
                    focusedDay: _focusedDay,
                    calendarFormat: _calendarFormat,
                    selectedDayPredicate: (day) => isSameDay(_selectedDay, day),
                    eventLoader: (day) => _getEventsForDay(day, state.schedules),
                    onDaySelected: (selectedDay, focusedDay) {
                      setState(() {
                        _selectedDay = selectedDay;
                        _focusedDay = focusedDay;
                      });
                    },
                    onFormatChanged: (format) => setState(() => _calendarFormat = format),
                    onPageChanged: (focusedDay) => _focusedDay = focusedDay,
                    headerStyle: const HeaderStyle(
                      titleCentered: true,
                      formatButtonVisible: true,
                      formatButtonShowsNext: false,
                      formatButtonDecoration: BoxDecoration(
                        color: Color(0xFFF2F4F6),
                        borderRadius: BorderRadius.all(Radius.circular(8)),
                      ),
                      formatButtonTextStyle: TextStyle(
                        fontSize: 11,
                        fontWeight: FontWeight.w600,
                        color: Color(0xFF4E5968),
                      ),
                      titleTextStyle: TextStyle(
                        fontSize: 15,
                        fontWeight: FontWeight.w700,
                        color: Color(0xFF191F28),
                      ),
                      leftChevronIcon: Icon(Icons.chevron_left_rounded, size: 20, color: Color(0xFF6B7684)),
                      rightChevronIcon: Icon(Icons.chevron_right_rounded, size: 20, color: Color(0xFF6B7684)),
                    ),
                    calendarStyle: const CalendarStyle(
                      todayDecoration: BoxDecoration(
                        color: Color(0xFFE8F3FF),
                        shape: BoxShape.circle,
                      ),
                      todayTextStyle: TextStyle(
                        color: Color(0xFF3182F6),
                        fontWeight: FontWeight.w700,
                      ),
                      selectedDecoration: BoxDecoration(
                        color: Color(0xFF191F28), // 포커스는 시크한 차콜 블랙
                        shape: BoxShape.circle,
                      ),
                      selectedTextStyle: TextStyle(
                        color: Colors.white,
                        fontWeight: FontWeight.w700,
                      ),
                      markersMaxCount: 1,
                      markerDecoration: BoxDecoration(
                        color: Color(0xFF3182F6),
                        shape: BoxShape.circle,
                      ),
                    ),
                  ),
                ),

                // 날짜 및 상태 인포 헤더
                Padding(
                  padding: const EdgeInsets.fromLTRB(20, 10, 20, 6),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      Text(
                        DateFormat('yyyy. MM. dd (E)', 'ko_KR').format(_selectedDay),
                        style: const TextStyle(
                          fontSize: 15,
                          fontWeight: FontWeight.w700,
                          color: Color(0xFF191F28),
                        ),
                      ),
                      Container(
                        padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 3),
                        decoration: BoxDecoration(
                          color: pendingCount > 0 ? const Color(0xFFE8F3FF) : const Color(0xFFF2F4F6),
                          borderRadius: BorderRadius.circular(6),
                        ),
                        child: Text(
                          '미완료 $pendingCount건',
                          style: TextStyle(
                            fontSize: 12,
                            fontWeight: FontWeight.w600,
                            color: pendingCount > 0 ? const Color(0xFF3182F6) : const Color(0xFF8B95A1),
                          ),
                        ),
                      ),
                    ],
                  ),
                ),

                // 일정 리스트
                Expanded(
                  child: RefreshIndicator(
                    color: const Color(0xFF3182F6),
                    onRefresh: () async {
                      if (currentUserId.isNotEmpty) {
                        await ref.read(scheduleProvider.notifier).fetchSchedules(userId: currentUserId);
                      }
                    },
                    child: selectedDayEvents.isEmpty
                        ? LayoutBuilder(
                            builder: (context, constraints) => SingleChildScrollView(
                              physics: const AlwaysScrollableScrollPhysics(),
                              child: ConstrainedBox(
                                constraints: BoxConstraints(minHeight: constraints.maxHeight),
                                child: Center(
                                  child: Column(
                                    mainAxisAlignment: MainAxisAlignment.center,
                                    children: [
                                      Icon(Icons.event_note_outlined, size: 40, color: Colors.grey.shade300),
                                      const SizedBox(height: 10),
                                      const Text(
                                        '등록된 일정이 없습니다',
                                        style: TextStyle(fontSize: 14, fontWeight: FontWeight.w600, color: Color(0xFF8B95A1)),
                                      ),
                                    ],
                                  ),
                                ),
                              ),
                            ),
                          )
                        : ListView.separated(
                            physics: const AlwaysScrollableScrollPhysics(),
                            padding: const EdgeInsets.fromLTRB(16, 8, 16, 80),
                            itemCount: selectedDayEvents.length,
                            separatorBuilder: (_, __) => const SizedBox(height: 8),
                            itemBuilder: (context, index) {
                              final item = selectedDayEvents[index];
                              final id = (item['id'] as num?)?.toInt() ?? 0;
                              final title = item['title']?.toString() ?? '';
                              final desc = item['description']?.toString() ?? '';
                              final completed = item['completed'] == true;
                              final dueDate = item['dueDate']?.toString();

                              return Dismissible(
                                key: Key('calendar_event_$id'),
                                direction: DismissDirection.endToStart,
                                background: Container(
                                  alignment: Alignment.centerRight,
                                  padding: const EdgeInsets.only(right: 20),
                                  decoration: BoxDecoration(
                                    color: const Color(0xFFE53935),
                                    borderRadius: BorderRadius.circular(12),
                                  ),
                                  child: const Icon(Icons.delete_outline_rounded, color: Colors.white, size: 22),
                                ),
                                onDismissed: (_) {
                                  ref.read(scheduleProvider.notifier).deleteSchedule(id, userId: currentUserId);
                                },
                                child: Material(
                                  color: Colors.white,
                                  borderRadius: BorderRadius.circular(12),
                                  child: InkWell(
                                    borderRadius: BorderRadius.circular(12),
                                    onTap: () async {
                                      await Navigator.push(
                                        context,
                                        MaterialPageRoute(
                                          builder: (_) => ScheduleWritePage(
                                            initialSchedule: item as Map<String, dynamic>,
                                          ),
                                        ),
                                      );
                                      if (currentUserId.isNotEmpty) {
                                        ref.read(scheduleProvider.notifier).fetchSchedules(userId: currentUserId);
                                      }
                                    },
                                    child: Container(
                                      padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 14),
                                      decoration: BoxDecoration(
                                        borderRadius: BorderRadius.circular(12),
                                        border: Border.all(color: const Color(0xFFE5E8EB)),
                                      ),
                                      child: Row(
                                        children: [
                                          GestureDetector(
                                            behavior: HitTestBehavior.opaque,
                                            onTap: () {
                                              ref.read(scheduleProvider.notifier).toggleComplete(id, userId: currentUserId);
                                            },
                                            child: AnimatedContainer(
                                              duration: const Duration(milliseconds: 150),
                                              width: 20,
                                              height: 20,
                                              decoration: BoxDecoration(
                                                shape: BoxShape.circle,
                                                color: completed ? const Color(0xFF3182F6) : Colors.transparent,
                                                border: Border.all(
                                                  color: completed ? const Color(0xFF3182F6) : const Color(0xFFB0B8C1),
                                                  width: 1.5,
                                                ),
                                              ),
                                              child: completed
                                                  ? const Icon(Icons.check, size: 14, color: Colors.white)
                                                  : null,
                                            ),
                                          ),
                                          const SizedBox(width: 12),
                                          Expanded(
                                            child: Column(
                                              crossAxisAlignment: CrossAxisAlignment.start,
                                              children: [
                                                Text(
                                                  title,
                                                  style: TextStyle(
                                                    fontSize: 15,
                                                    fontWeight: FontWeight.w600,
                                                    color: completed ? const Color(0xFFB0B8C1) : const Color(0xFF191F28),
                                                    decoration: completed ? TextDecoration.lineThrough : null,
                                                  ),
                                                ),
                                                if (desc.isNotEmpty) ...[
                                                  const SizedBox(height: 2),
                                                  Text(
                                                    desc,
                                                    style: TextStyle(
                                                      fontSize: 13,
                                                      color: completed ? const Color(0xFFB0B8C1) : const Color(0xFF6B7684),
                                                    ),
                                                    maxLines: 1,
                                                    overflow: TextOverflow.ellipsis,
                                                  ),
                                                ],
                                                if (dueDate != null && dueDate.length >= 16) ...[
                                                  const SizedBox(height: 6),
                                                  Row(
                                                    children: [
                                                      const Icon(Icons.schedule_rounded, size: 12, color: Color(0xFF8B95A1)),
                                                      const SizedBox(width: 4),
                                                      Text(
                                                        dueDate.substring(11, 16),
                                                        style: const TextStyle(
                                                          fontSize: 12,
                                                          fontWeight: FontWeight.w500,
                                                          color: Color(0xFF6B7684),
                                                        ),
                                                      ),
                                                    ],
                                                  ),
                                                ],
                                              ],
                                            ),
                                          ),
                                          const Icon(Icons.chevron_right_rounded, size: 18, color: Color(0xFFD1D6DB)),
                                        ],
                                      ),
                                    ),
                                  ),
                                ),
                              );
                            },
                          ),
                  ),
                ),
              ],
            ),
      floatingActionButton: FloatingActionButton(
        backgroundColor: const Color(0xFF191F28), // 모던 차콜 블랙 버튼
        elevation: 2,
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(14)),
        child: const Icon(Icons.add, color: Colors.white, size: 24),
        onPressed: () async {
          await Navigator.push(
            context,
            MaterialPageRoute(
              builder: (context) => ScheduleWritePage(
                initialSchedule: {
                  'dueDate': DateTime(
                    _selectedDay.year,
                    _selectedDay.month,
                    _selectedDay.day,
                    DateTime.now().hour,
                    DateTime.now().minute,
                  ).toIso8601String(),
                },
              ),
            ),
          );
          if (currentUserId.isNotEmpty) {
            ref.read(scheduleProvider.notifier).fetchSchedules(userId: currentUserId);
          }
        },
      ),
    );
  }
}