import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:schedule_app/features/auth/data/auth_provider.dart';
import '../data/schedule_provider.dart';

class ScheduleWritePage extends ConsumerStatefulWidget {
  final Map<String, dynamic>? initialSchedule;

  const ScheduleWritePage({super.key, this.initialSchedule});

  @override
  ConsumerState<ScheduleWritePage> createState() => _ScheduleWritePageState();
}

class _ScheduleWritePageState extends ConsumerState<ScheduleWritePage> {
  late final TextEditingController _titleController;
  late final TextEditingController _descController;
  DateTime? _selectedDate;

  bool get _isEditMode => widget.initialSchedule?['id'] != null;

  @override
  void initState() {
    super.initState();
    final initial = widget.initialSchedule;
    _titleController = TextEditingController(text: initial?['title']?.toString() ?? '');
    _descController = TextEditingController(text: initial?['description']?.toString() ?? '');

    if (initial?['dueDate'] != null) {
      _selectedDate = DateTime.tryParse(initial!['dueDate'].toString());
    }
  }

  @override
  void dispose() {
    _titleController.dispose();
    _descController.dispose();
    super.dispose();
  }

  Future<void> _handleDelete() async {
    final confirm = await showDialog<bool>(
      context: context,
      builder: (dialogCtx) => AlertDialog(
        backgroundColor: Colors.white,
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(14)),
        title: const Text(
          '일정 삭제',
          style: TextStyle(
            fontSize: 16,
            fontWeight: FontWeight.w700,
            color: Color(0xFF191F28),
          ),
        ),
        content: const Text(
          '선택한 일정을 삭제하시겠습니까?',
          style: TextStyle(fontSize: 14, color: Color(0xFF4E5968), height: 1.4),
        ),
        actionsPadding: const EdgeInsets.symmetric(horizontal: 16, vertical: 12),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(dialogCtx, false),
            child: const Text(
              '취소',
              style: TextStyle(color: Color(0xFF8B95A1), fontWeight: FontWeight.w600),
            ),
          ),
          ElevatedButton(
            style: ElevatedButton.styleFrom(
              backgroundColor: const Color(0xFFE53935),
              foregroundColor: Colors.white,
              elevation: 0,
              shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(8)),
            ),
            onPressed: () => Navigator.pop(dialogCtx, true),
            child: const Text('삭제', style: TextStyle(fontWeight: FontWeight.w600)),
          ),
        ],
      ),
    );

    if (confirm == true) {
      final user = ref.read(authProvider).user;
      final userId = user?['id']?.toString() ?? user?['userId']?.toString() ?? '1';
      final int scheduleId = (widget.initialSchedule!['id'] as num).toInt();

      final success = await ref.read(scheduleProvider.notifier).deleteSchedule(
            scheduleId,
            userId: userId,
          );

      if (success && mounted) {
        Navigator.pop(context);
      }
    }
  }

  Future<void> _pickDateTime() async {
    final now = DateTime.now();
    final pickedDate = await showDatePicker(
      context: context,
      initialDate: _selectedDate ?? now,
      firstDate: DateTime(2020),
      lastDate: DateTime(2035),
      builder: (context, child) {
        return Theme(
          data: Theme.of(context).copyWith(
            colorScheme: const ColorScheme.light(
              primary: Color(0xFF3182F6),
              onPrimary: Colors.white,
              onSurface: Color(0xFF191F28),
            ),
          ),
          child: child!,
        );
      },
    );

    if (pickedDate == null || !mounted) return;

    final pickedTime = await showTimePicker(
      context: context,
      initialTime: _selectedDate != null
          ? TimeOfDay(hour: _selectedDate!.hour, minute: _selectedDate!.minute)
          : TimeOfDay.now(),
      builder: (context, child) {
        return Theme(
          data: Theme.of(context).copyWith(
            colorScheme: const ColorScheme.light(
              primary: Color(0xFF3182F6),
              onPrimary: Colors.white,
              onSurface: Color(0xFF191F28),
            ),
          ),
          child: child!,
        );
      },
    );

    if (pickedTime == null || !mounted) return;

    setState(() {
      _selectedDate = DateTime(
        pickedDate.year,
        pickedDate.month,
        pickedDate.day,
        pickedTime.hour,
        pickedTime.minute,
      );
    });
  }

  void _handleSubmit() async {
    final title = _titleController.text.trim();
    if (title.isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text('제목을 입력해주세요.')),
      );
      return;
    }

    final user = ref.read(authProvider).user;
    final userId = user?['id']?.toString() ?? user?['userId']?.toString() ?? '1';

    bool success = false;

    if (_isEditMode) {
      final int scheduleId = (widget.initialSchedule!['id'] as num).toInt();
      success = await ref.read(scheduleProvider.notifier).updateSchedule(
            id: scheduleId,
            userId: userId,
            title: title,
            description: _descController.text.trim(),
            dueDate: _selectedDate,
          );
    } else {
      success = await ref.read(scheduleProvider.notifier).createSchedule(
            userId: userId,
            title: title,
            description: _descController.text.trim(),
            dueDate: _selectedDate,
          );
    }

    if (success && mounted) {
      Navigator.pop(context);
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFFF8F9FA),
      appBar: AppBar(
        titleSpacing: 0,
        leading: IconButton(
          icon: const Icon(Icons.arrow_back_ios_new_rounded, size: 18),
          onPressed: () => Navigator.pop(context),
        ),
        title: Text(
          _isEditMode ? '일정 수정' : '새 일정',
          style: const TextStyle(
            fontSize: 17,
            fontWeight: FontWeight.w700,
            color: Color(0xFF191F28),
          ),
        ),
        actions: [
          if (_isEditMode)
            IconButton(
              tooltip: '삭제',
              icon: const Icon(Icons.delete_outline_rounded, color: Color(0xFFE53935), size: 22),
              onPressed: _handleDelete,
            ),
          const SizedBox(width: 6),
        ],
      ),
      body: SafeArea(
        child: SingleChildScrollView(
          padding: const EdgeInsets.symmetric(horizontal: 20.0, vertical: 16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Container(
                padding: const EdgeInsets.all(20),
                decoration: BoxDecoration(
                  color: Colors.white,
                  borderRadius: BorderRadius.circular(14),
                  border: Border.all(color: const Color(0xFFE5E8EB)),
                ),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    const Text(
                      '일정 제목',
                      style: TextStyle(
                        fontSize: 13,
                        fontWeight: FontWeight.w600,
                        color: Color(0xFF4E5968),
                      ),
                    ),
                    const SizedBox(height: 8),
                    TextField(
                      controller: _titleController,
                      style: const TextStyle(fontSize: 15, fontWeight: FontWeight.w600, color: Color(0xFF191F28)),
                      decoration: const InputDecoration(
                        hintText: '일정 제목을 입력하세요',
                        filled: true,
                        fillColor: Color(0xFFF8F9FA),
                      ),
                    ),
                    const SizedBox(height: 20),

                    const Text(
                      '마감 일시',
                      style: TextStyle(
                        fontSize: 13,
                        fontWeight: FontWeight.w600,
                        color: Color(0xFF4E5968),
                      ),
                    ),
                    const SizedBox(height: 8),
                    InkWell(
                      borderRadius: BorderRadius.circular(12),
                      onTap: _pickDateTime,
                      child: Container(
                        padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 14),
                        decoration: BoxDecoration(
                          color: const Color(0xFFF8F9FA),
                          borderRadius: BorderRadius.circular(12),
                          border: Border.all(color: const Color(0xFFE5E8EB)),
                        ),
                        child: Row(
                          children: [
                            const Icon(Icons.calendar_today_rounded, size: 16, color: Color(0xFF4E5968)),
                            const SizedBox(width: 10),
                            Expanded(
                              child: Text(
                                _selectedDate == null
                                    ? '날짜 및 시간을 선택하세요'
                                    : '${_selectedDate!.year}. ${_selectedDate!.month.toString().padLeft(2, '0')}. ${_selectedDate!.day.toString().padLeft(2, '0')}  ${_selectedDate!.hour.toString().padLeft(2, '0')}:${_selectedDate!.minute.toString().padLeft(2, '0')}',
                                style: TextStyle(
                                  fontSize: 14,
                                  fontWeight: FontWeight.w500,
                                  color: _selectedDate == null ? const Color(0xFF8B95A1) : const Color(0xFF191F28),
                                ),
                              ),
                            ),
                            if (_selectedDate != null)
                              GestureDetector(
                                onTap: () => setState(() => _selectedDate = null),
                                child: const Icon(Icons.cancel_rounded, size: 16, color: Color(0xFF8B95A1)),
                              )
                            else
                              const Icon(Icons.chevron_right_rounded, size: 18, color: Color(0xFF8B95A1)),
                          ],
                        ),
                      ),
                    ),
                    const SizedBox(height: 20),

                    const Text(
                      '상세 설명',
                      style: TextStyle(
                        fontSize: 13,
                        fontWeight: FontWeight.w600,
                        color: Color(0xFF4E5968),
                      ),
                    ),
                    const SizedBox(height: 8),
                    TextField(
                      controller: _descController,
                      maxLines: 4,
                      style: const TextStyle(fontSize: 14, color: Color(0xFF191F28)),
                      decoration: const InputDecoration(
                        hintText: '필요한 세부 메모를 입력하세요',
                        filled: true,
                        fillColor: Color(0xFFF8F9FA),
                      ),
                    ),
                  ],
                ),
              ),
              const SizedBox(height: 24),

              SizedBox(
                width: double.infinity,
                height: 48,
                child: ElevatedButton(
                  style: ElevatedButton.styleFrom(
                    backgroundColor: const Color(0xFF3182F6),
                    elevation: 0,
                    shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
                  ),
                  onPressed: _handleSubmit,
                  child: Text(
                    _isEditMode ? '저장' : '일정 생성',
                    style: const TextStyle(
                      fontSize: 15,
                      fontWeight: FontWeight.w700,
                      color: Colors.white,
                    ),
                  ),
                ),
              ),

              if (_isEditMode) ...[
                const SizedBox(height: 10),
                SizedBox(
                  width: double.infinity,
                  height: 48,
                  child: OutlinedButton(
                    style: OutlinedButton.styleFrom(
                      side: const BorderSide(color: Color(0xFFE5E8EB)),
                      backgroundColor: Colors.white,
                      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
                    ),
                    onPressed: _handleDelete,
                    child: const Text(
                      '일정 삭제',
                      style: TextStyle(
                        fontSize: 14,
                        fontWeight: FontWeight.w600,
                        color: Color(0xFFE53935),
                      ),
                    ),
                  ),
                ),
              ],
            ],
          ),
        ),
      ),
    );
  }
}