package com.example.courseselectmodule.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class StudentSelectedCourseDto {

    @ApiModelProperty(value = "学生信息", required = true)
    private String studentId;

    @ApiModelProperty(value = "课程信息列表", required = true)
    private List<CourseInfoDto> courseList;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public List<CourseInfoDto> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseInfoDto> courseList) {
        this.courseList = courseList;
    }
}
