package com.example.courseselectmodule.dto;

import java.io.Serializable;

/**
 * 学生选课结果表
 * @TableName student_course_info
 */
public class StudentCourseInfoDto implements Serializable {
    /**
     * 
     */
    private String stuId;

    /**
     * 
     */
    private String courseId;

    /**
     * 
     */
    public String getStuId() {
        return stuId;
    }

    /**
     * 
     */
    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    /**
     * 
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * 
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}