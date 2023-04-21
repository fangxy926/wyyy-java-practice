package com.example.courseselectmodule.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class CourseInfoDto {

    @ApiModelProperty(value = "课程代码", required = true)
    private String courseId;

    @ApiModelProperty(value = "课程名")
    private String courseName;


    @ApiModelProperty(value = "课程报选人数上限")
    private Integer courseLimit;


    @ApiModelProperty(value = "上课时间（星期）", example = "1", dataType = "java.util.Integer")
    private Integer courseWeekDay;


    @ApiModelProperty(value = "上课时间（开始时刻）")
    private Date courseStartTime;

    @ApiModelProperty(value = "上课时间（结束时刻）")
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
