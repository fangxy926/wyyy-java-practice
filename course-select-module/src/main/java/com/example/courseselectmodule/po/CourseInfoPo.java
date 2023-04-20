package com.example.courseselectmodule.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 选修课程信息表
 * @TableName course_info
 */
public class CourseInfoPo implements Serializable {
    /**
     * 
     */
    private Long id;

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

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 课程ID
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * 课程ID
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * 课程名
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * 课程名
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * 课程报选人数上线
     */
    public Integer getCourseLimit() {
        return courseLimit;
    }

    /**
     * 课程报选人数上线
     */
    public void setCourseLimit(Integer courseLimit) {
        this.courseLimit = courseLimit;
    }

    /**
     * 上课时间（星期）
     */
    public Integer getCourseWeekDay() {
        return courseWeekDay;
    }

    /**
     * 上课时间（星期）
     */
    public void setCourseWeekDay(Integer courseWeekDay) {
        this.courseWeekDay = courseWeekDay;
    }

    /**
     * 上课时间（开始时刻）
     */
    public Date getCourseStartTime() {
        return courseStartTime;
    }

    /**
     * 上课时间（开始时刻）
     */
    public void setCourseStartTime(Date courseStartTime) {
        this.courseStartTime = courseStartTime;
    }

    /**
     * 上课时间（j结束时刻）
     */
    public Date getCourseEndTime() {
        return courseEndTime;
    }

    /**
     * 上课时间（j结束时刻）
     */
    public void setCourseEndTime(Date courseEndTime) {
        this.courseEndTime = courseEndTime;
    }
}