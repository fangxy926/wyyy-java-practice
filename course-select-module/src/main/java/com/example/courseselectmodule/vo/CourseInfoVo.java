package com.example.courseselectmodule.vo;

import com.example.studentmodule.vo.StudentInfoVo;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 选修课程信息表
 *
 * @TableName course_info
 */
public class CourseInfoVo implements Serializable {

    @ApiModelProperty(value = "课程代码", example = "XC001")
    private String courseId;

    @ApiModelProperty(value = "课程名")
    private String courseName;

    @ApiModelProperty(value = "已报人数")
    private Integer courseSelected;

    @ApiModelProperty(value = "剩余可报人数")
    private Integer courseRemain;

    @ApiModelProperty(value = "课程报选人数上限")
    private Integer courseLimit;

    @ApiModelProperty(value = "上课时间", example = "周一 8:00-9:40")
    private String courseTimeRange;

    @ApiModelProperty(value = "报课学生列表")
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