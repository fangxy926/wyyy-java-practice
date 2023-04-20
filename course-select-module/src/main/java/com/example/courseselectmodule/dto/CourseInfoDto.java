package com.example.courseselectmodule.dto;

import java.util.Date;

public class CourseInfoDto {
    /**
     * 课程ID
     */
    private String courseId;

    /**
     * 课程名
     */
    private String courseName;

    /**
     * 课程报选人数上线
     */
    private Integer courseLimit;

    /**
     * 上课时间（星期）
     */
    private Integer courseWeekDay;

    /**
     * 上课时间（开始时刻）
     */
    private Date courseStartTime;

    /**
     * 上课时间（j结束时刻）
     */
    private Date courseEndTime;


    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseLimit() {
        return courseLimit;
    }

    public void setCourseLimit(Integer courseLimit) {
        this.courseLimit = courseLimit;
    }

    public Integer getCourseWeekDay() {
        return courseWeekDay;
    }

    public void setCourseWeekDay(Integer courseWeekDay) {
        this.courseWeekDay = courseWeekDay;
    }

    public Date getCourseStartTime() {
        return courseStartTime;
    }

    public void setCourseStartTime(Date courseStartTime) {
        this.courseStartTime = courseStartTime;
    }

    public Date getCourseEndTime() {
        return courseEndTime;
    }

    public void setCourseEndTime(Date courseEndTime) {
        this.courseEndTime = courseEndTime;
    }
}
