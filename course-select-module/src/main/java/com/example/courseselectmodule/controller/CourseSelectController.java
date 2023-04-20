package com.example.courseselectmodule.controller;


import com.example.commonmodule.response.ServerResponse;
import com.example.courseselectmodule.dto.CourseInfoDto;
import com.example.courseselectmodule.dto.StudentSelectedCourseDto;
import com.example.courseselectmodule.service.CourseSelectService;
import com.example.courseselectmodule.vo.CourseInfoVo;
import com.example.studentmodule.vo.StudentInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "学生选课接口API")
@RequestMapping("/course_select")
public class CourseSelectController {

    @Autowired
    private CourseSelectService courseSelectService;

    @PostMapping(value = "/submit")
    @ApiOperation(value = "学生报选选修课接口")
    public ServerResponse<String> submitCourse(@RequestBody StudentSelectedCourseDto dto) {
        try {
            return courseSelectService.submitSelection(dto);
        } catch (Exception e) {
            return ServerResponse.createByErrorMessage("选课失败，内部错误");
        }
    }

    @PostMapping(value = "/student_course")
    @ApiOperation(value = "根据学号查询选修课选修结果接口")
    public ServerResponse<List<CourseInfoVo>> submitCourse(@RequestParam("studentId") String studentId) {
        try {
            return courseSelectService.listByStudentId(studentId);
        } catch (Exception e) {
            return ServerResponse.createByErrorMessage("选课失败，内部错误");
        }
    }

    @PostMapping(value = "/listCourseInfo")
    @ApiOperation(value = "根据课程ID列表查询已选报人数和剩余可报人数接口")
    public ServerResponse<List<CourseInfoVo>> listCourseInfo(@RequestParam("courseList") List<String> courseList) {
        try {
            return courseSelectService.batchListCourseInfo(courseList);
        } catch (Exception e) {
            return ServerResponse.createByErrorMessage("选课失败，内部错误");

        }
    }

    @PostMapping(value = "/listStudentsInfo")
    @ApiOperation(value = "根据课程ID查询选修学生信息列表接口")
    public ServerResponse<List<StudentInfoVo>> listStudentsInfo(@RequestParam("courseId") String courseId) {
        try {
            CourseInfoDto dto = new CourseInfoDto();
            dto.setCourseId(courseId);
            return courseSelectService.listStudentInfo(dto);
        } catch (Exception e) {
            return ServerResponse.createByErrorMessage("选课失败，内部错误");
        }
    }
}
