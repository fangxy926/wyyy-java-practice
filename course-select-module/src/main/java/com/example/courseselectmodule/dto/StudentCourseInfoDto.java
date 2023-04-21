package com.example.courseselectmodule.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 学生选课结果表
 *
 * @TableName student_course_info
 */
public class StudentCourseInfoDto implements Serializable {


    @ApiModelProperty(value = "学号", example = "2022001")
    private String stuId;

    @ApiModelProperty(value = "课程代码", example = "XC001")
    private String courseId;


    public String getStuId() {
        return stuId;
    }


    public void setStuId(String stuId) {
        this.stuId = stuId;
    }


    public String getCourseId() {
        return courseId;
    }


    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}