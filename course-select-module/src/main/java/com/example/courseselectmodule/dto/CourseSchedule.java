package com.example.courseselectmodule.dto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程时间类
 */
public class CourseSchedule {
    private int dayOfWeek; // 星期
    private LocalTime startTime; // 开始时间
    private LocalTime endTime; // 结束时间

    public CourseSchedule(int dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public static boolean hasConflict(List<CourseSchedule> schedules) {
        for (int i = 0; i < schedules.size(); i++) {
            CourseSchedule scheduleA = schedules.get(i);
            for (int j = i + 1; j < schedules.size(); j++) {
                CourseSchedule scheduleB = schedules.get(j);
                if (scheduleA.getDayOfWeek() == scheduleB.getDayOfWeek()) {
                    if (scheduleA.getEndTime().isBefore(scheduleB.getStartTime()) ||
                            scheduleA.getStartTime().isAfter(scheduleB.getEndTime())) {
                        // 无冲突
                    } else {
                        return true; // 有冲突
                    }
                }
            }
        }

        return false; // 无冲突
    }

    public static void main(String[] args) {
        List<CourseSchedule> schedules = new ArrayList<>();
        schedules.add(new CourseSchedule(1, LocalTime.of(9, 0), LocalTime.of(10, 30)));
        schedules.add(new CourseSchedule(1, LocalTime.of(11, 0), LocalTime.of(12, 30)));
        schedules.add(new CourseSchedule(2, LocalTime.of(9, 0), LocalTime.of(10, 30)));
        schedules.add(new CourseSchedule(3, LocalTime.of(13, 0), LocalTime.of(14, 30)));

        boolean hasConflict = CourseSchedule.hasConflict(schedules);
        System.out.println("Has conflict: " + hasConflict);
    }
}
