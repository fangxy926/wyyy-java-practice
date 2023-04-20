package com.example.courseselectmodule.vo;

import com.example.studentmodule.vo.StudentInfoVo;

import java.io.Serializable;
import java.util.List;

/**
 * 选修课程信息表
 *
 * @TableName course_info
 */
public class CourseInfoVo implements Serializable {
    /**
     * 课程ID
     */
    private String courseId;
    /**
     * 课程名
     */
    private String courseName;

    /**
     * 已报人数
     */
    private Integer courseSelected;
    /**
     * 剩余可报人数
     */
    private Integer courseRemain;
    /**
     * 课程报选人数上线
     */
    private Integer courseLimit;
    /**
     * 上课时间 星期 + 时间段
     */
    private String courseTimeRange;

    /**
     * 已选学生列表
     */
    private List<StudentInfoVo> courseStudents;

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

    public Integer getCourseSelected() {
        return courseSelected;
    }

    public void setCourseSelected(Integer courseSelected) {
        this.courseSelected = courseSelected;
    }

    public Integer getCourseRemain() {
        return courseRemain;
    }

    public void setCourseRemain(Integer courseRemain) {
        this.courseRemain = courseRemain;
    }

    public Integer getCourseLimit() {
        return courseLimit;
    }

    public void setCourseLimit(Integer courseLimit) {
        this.courseLimit = courseLimit;
    }

    public String getCourseTimeRange() {
        return courseTimeRange;
    }

    public void setCourseTimeRange(String courseTimeRange) {
        this.courseTimeRange = courseTimeRange;
    }

    public List<StudentInfoVo> getCourseStudents() {
        return courseStudents;
    }

    public void setCourseStudents(List<StudentInfoVo> courseStudents) {
        this.courseStudents = courseStudents;
    }
}