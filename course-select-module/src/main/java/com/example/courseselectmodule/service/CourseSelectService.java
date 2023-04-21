package com.example.courseselectmodule.service;

import com.example.commonmodule.response.ServerResponse;
import com.example.courseselectmodule.dto.CourseInfoDto;
import com.example.courseselectmodule.vo.CourseInfoVo;
import com.example.studentmodule.dto.StudentInfoDto;
import com.example.studentmodule.vo.StudentInfoVo;

import java.util.List;

public interface CourseSelectService {

    /**
     * 学生报选选修课接口
     */
    ServerResponse<String> submitSelection(StudentInfoDto student, List<CourseInfoDto> courseList);


    /**
     * 根据学号查询选修课选修结果接口
     *
     * @param studentId
     * @return
     */
    ServerResponse<List<CourseInfoVo>> listByStudentId(String studentId);


    /**
     * 根据课程ID查询已选报人数和剩余可报人数接口
     *
     * @param courseInfoDto
     * @return
     */
    ServerResponse<CourseInfoVo> getCourseInfo(CourseInfoDto courseInfoDto);

    /**
     * 根据课程ID列表查询已选报人数和剩余可报人数接口
     *
     * @param courseIdList
     * @return
     */
    ServerResponse<List<CourseInfoVo>> batchListCourseInfo(List<String> courseIdList);

    /**
     * 根据课程ID查询选修学生信息列表接口
     *
     * @param courseInfoDto
     * @return
     */
    ServerResponse<List<StudentInfoVo>> listStudentInfo(CourseInfoDto courseInfoDto);

    /**
     * 合法课程列表校验
     *
     * @param strings
     * @return
     */
    ServerResponse<Boolean> isValidCourseList(List<String> courseList);
}
