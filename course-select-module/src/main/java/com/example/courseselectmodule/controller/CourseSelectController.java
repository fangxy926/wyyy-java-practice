package com.example.courseselectmodule.controller;


import com.example.commonmodule.response.ServerResponse;
import com.example.courseselectmodule.dto.CourseInfoDto;
import com.example.courseselectmodule.dto.StudentSelectedCourseDto;
import com.example.courseselectmodule.service.CourseSelectService;
import com.example.courseselectmodule.vo.CourseInfoVo;
import com.example.studentmodule.dto.StudentInfoDto;
import com.example.studentmodule.vo.StudentInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "学生选课接口API")
@RequestMapping("/course_select")
public class CourseSelectController {

    @Autowired
    private CourseSelectService courseSelectService;

    private static final Logger logger = LoggerFactory.getLogger(CourseSelectController.class);

    @PostMapping(value = "/submit")
    @ApiOperation(value = "学生报选选修课接口")
    public ServerResponse<String> submitCourse(@RequestBody StudentSelectedCourseDto dto) {
        try {
            StudentInfoDto studentInfo = new StudentInfoDto();
            studentInfo.setStuId(dto.getStudentId());
            List<CourseInfoDto> courseList = dto.getCourseList();
            return courseSelectService.submitSelection(studentInfo, courseList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ServerResponse.createByErrorMessage("选课失败，内部错误");
        }
    }

    @PostMapping(value = "/student_course")
    @ApiOperation(value = "根据学号查询选修课选修结果接口")
    public ServerResponse<List<CourseInfoVo>> submitCourse(@RequestParam("studentId") @ApiParam(value = "学号", required = true, example = "2023001") String studentId) {
        try {
            return courseSelectService.listByStudentId(studentId);
        } catch (Exception e) {
            logger.error(e.toString());
            return ServerResponse.createByErrorMessage("选课失败，内部错误");
        }
    }

    @PostMapping(value = "/listCourseInfo")
    @ApiOperation(value = "根据课程ID列表查询已选报人数和剩余可报人数接口")
    public ServerResponse<List<CourseInfoVo>> listCourseInfo(@RequestParam("courseList") @ApiParam(value = "课程代码列表", required = true, example = "['XC001', 'XC002']") List<String> courseList) {
        try {
            return courseSelectService.batchListCourseInfo(courseList);
        } catch (Exception e) {
            logger.error(e.toString());
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("获取失败，内部错误");
        }
    }

    @PostMapping(value = "/listStudentsInfo")
    @ApiOperation(value = "根据课程ID查询选修学生信息列表接口")
    public ServerResponse<List<StudentInfoVo>> listStudentsInfo(@RequestParam("courseId") @ApiParam(value = "课程代码", required = true, example = "XC001") String courseId) {
        try {
            CourseInfoDto dto = new CourseInfoDto();
            dto.setCourseId(courseId);
            return courseSelectService.listStudentInfo(dto);
        } catch (Exception e) {
            logger.error(e.toString());
            return ServerResponse.createByErrorMessage("获取失败，内部错误");
        }
    }
}
