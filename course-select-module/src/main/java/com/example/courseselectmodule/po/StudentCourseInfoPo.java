package com.example.courseselectmodule.po;

import java.io.Serializable;

/**
 * 学生选课结果表
 * @TableName student_course_info
 */
public class StudentCourseInfoPo implements Serializable {

    private Long id;

    /**
     * 学生id
     */
    private String stuId;

    /**
     * 课程id
     */
    private String courseId;

    private static final long serialVersionUID = 1L;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


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