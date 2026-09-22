package com.thejoa703.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thejoa703.entity.Schedule;
import com.thejoa703.repository.ScheduleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ScheduleService {
	
	private final ScheduleRepository scheduleRepository;
	
	// 특정 사용자의 일정 목록 조회
	@Transactional(readOnly = true)
	public List<Schedule> getSchedules(String userId) {
		return scheduleRepository.findByUserIdOrderByDueDateAsc(userId);	
	}
	
	// 일정 등록
	public Schedule createSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}
	
	// 완료 상태 토글 
	public Schedule toggleComplete(Long id) {
		Schedule schedule = scheduleRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다. ID: " + id));
		
		schedule.setCompleted(!schedule.isCompleted());
		return schedule;
	}
	
	// 일정 삭제
	public void deleteSchedule(Long id) {
		scheduleRepository.deleteById(id);
	}

	// ⭐️ 추가: 일정 내용(제목, 설명, 마감일) 수정
	public Schedule updateSchedule(Long id, Schedule updatedData) {
		Schedule schedule = scheduleRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다. ID: " + id));

		schedule.setTitle(updatedData.getTitle());
		schedule.setDescription(updatedData.getDescription());
		if (updatedData.getDueDate() != null) {
			schedule.setDueDate(updatedData.getDueDate());
		}
		
		// @Transactional 클래스이므로 dirty checking(변경 감지)에 의해 자동 DB 반영
		return schedule;
	}
}