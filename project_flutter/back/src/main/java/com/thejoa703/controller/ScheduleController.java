package com.thejoa703.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thejoa703.entity.Schedule;
import com.thejoa703.service.ScheduleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    
    private final ScheduleService scheduleService;
    
    // 목록 조회 (name = "userId" 명시)
    @GetMapping
    public ResponseEntity<List<Schedule>> getList(
            @RequestParam(name = "userId", required = false, defaultValue = "1") String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            userId = "1";
        }
        return ResponseEntity.ok(scheduleService.getSchedules(userId));
    }
    
    // 일정 등록
    @PostMapping
    public ResponseEntity<Schedule> create(@RequestBody Schedule schedule) {
        return ResponseEntity.ok(scheduleService.createSchedule(schedule));
    }
    
    // 완료 상태 토글 (name = "id" 명시)
    @PatchMapping("/{id}/toggle")
    public ResponseEntity<Schedule> toggle(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(scheduleService.toggleComplete(id));
    }
    
    // 일정 수정
    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(
            @PathVariable(name = "id") Long id,
            @RequestBody Schedule schedule) {
        return ResponseEntity.ok(scheduleService.updateSchedule(id, schedule));
    }

    // 일정 삭제 (name = "id" 명시)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.ok().build();
    }
}