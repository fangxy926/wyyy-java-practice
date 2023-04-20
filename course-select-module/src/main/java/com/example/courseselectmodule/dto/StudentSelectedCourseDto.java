package com.example.courseselectmodule.dto;

import com.example.studentmodule.dto.StudentInfoDto;

import java.util.List;

public class StudentSelectedCourseDto {

    /**
     * 学生信息
     */
    private StudentInfoDto studentInfo;
    /**
     * 课程信息列表
     */
    private List<CourseInfoDto> courseList;

    public StudentInfoDto getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfoDto studentInfo) {
        this.studentInfo = studentInfo;
    }

    public List<CourseInfoDto> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseInfoDto> courseList) {
        this.courseList = courseList;
    }
}
