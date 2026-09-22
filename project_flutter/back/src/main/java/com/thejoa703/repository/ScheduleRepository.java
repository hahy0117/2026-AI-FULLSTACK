package com.thejoa703.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.thejoa703.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    // 특정 유저의 일정 목록 조회 (마감일 기준 오름차순)
    List<Schedule> findByUserIdOrderByDueDateAsc(String userId);

}