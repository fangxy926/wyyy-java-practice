package com.example.studentmodule.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.commonmodule.response.ServerResponse;
import com.example.studentmodule.dto.StudentInfoDto;
import com.example.studentmodule.service.StudentService;
import com.example.studentmodule.vo.StudentInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "学生信息接口API")
@RequestMapping("/student_info")
public class StudentInfoController {

    @Autowired
    private StudentService studentService;

    private final Logger logger = LoggerFactory.getLogger(StudentInfoController.class);

    @PostMapping(value = "/add")
    @ApiOperation(value = "添加学生")
    public ServerResponse<String> addStudent(@RequestBody StudentInfoDto studentInfoDto) {
        try {
            return studentService.addStudent(studentInfoDto);
        } catch (Exception e) {
            logger.error(e.toString());
            return ServerResponse.createByErrorMessage("新增失败，内部错误");
        }
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改学生信息")
    public ServerResponse<String> updateStudent(@RequestBody StudentInfoDto studentInfoDto) {
        try {
            return studentService.updateStudent(studentInfoDto);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return ServerResponse.createByErrorMessage("修改失败，内部错误");
        }
    }

    @PostMapping(value = "/search")
    @ApiOperation(value = "根据学号查询学生信息接口（无班级名称）")
    public ServerResponse<StudentInfoVo> getStudentInfo(@RequestParam(value = "studentID") String studentID) {
        try {
            return studentService.searchStudentInfoByID(studentID);
        } catch (Exception e) {
            logger.error(e.toString());
            return ServerResponse.createByErrorMessage("获取失败");
        }
    }

    @PostMapping(value = "/searchWithClassInfo")
    @ApiOperation(value = "根据学号查询学生信息接口（含班级名称）")
    public ServerResponse<StudentInfoVo> getStudentInfoWithClass(@RequestParam(value = "studentID") String studentID) {
        try {
            return studentService.searchStudentInfoWithClassInfoByID(studentID);
        } catch (Exception e) {
            logger.error(e.toString());
            return ServerResponse.createByErrorMessage("获取失败");
        }
    }

    @PostMapping(value = "/pageListByClass")
    @ApiOperation(value = "根据班级代码获取班级所有学生的信息(分页)")
    public ServerResponse<IPage<StudentInfoVo>> pageListByClass(@RequestParam(value = "classID") String classID,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                                @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        try {
            return studentService.pageListByClass(classID, pageNum, pageSize);
        } catch (Exception e) {
            logger.error(e.toString());
            return ServerResponse.createByErrorMessage("获取失败");
        }
    }

    @PostMapping(value = "/pageListOrderByAge")
    @ApiOperation(value = "按照年龄排序获取所有学生列表数据(分页)")
    public ServerResponse<IPage<StudentInfoVo>> pageListOrderByAge(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                                   @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                                   @RequestParam(value = "order", defaultValue = "desc") String order) {
        try {
            return studentService.pageListOrderByAge(pageNum, pageSize, order);
        } catch (Exception e) {
            logger.error(e.toString());
            return ServerResponse.createByErrorMessage("获取失败");
        }
    }
}
