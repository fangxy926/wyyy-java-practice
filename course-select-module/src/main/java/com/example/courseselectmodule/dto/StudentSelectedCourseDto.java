package com.example.courseselectmodule.dto;

import java.util.List;

public class StudentSelectedCourseDto {

    /**
     * 学生信息
     */
    private String studentId;
    /**
     * 课程信息列表
     */
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
