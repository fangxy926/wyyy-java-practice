package com.example.studentmodule.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.commonmodule.response.ServerResponse;
import com.example.studentmodule.po.StudentInfoPo;
import com.example.studentmodule.service.StudentService;
import com.example.studentmodule.util.DBUtil;
import com.example.studentmodule.util.DateUtil;
import com.example.studentmodule.po.StudentInfoPoExt;
import com.example.studentmodule.vo.StudentInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "学生信息接口API")
@RequestMapping("/student_info")
public class StudentInfoController {

    @Autowired
    private StudentService studentService;


    private StudentInfoPo requestBodyToStudentInfoPo(Map<String, Object> body) throws ParseException {
        StudentInfoPo student = new StudentInfoPo();
        String stuId = (String) body.get("stuId");
        student.setStuId(stuId);
        String stuName = (String) body.get("stuName");
        student.setStuName(stuName);
        String stuSex = (String) body.get("stuSex");
        student.setStuSex(stuSex);
        Date stuBirthday = DateUtil.stringToDate((String) body.get("stuBirthday"));
        student.setStuBirthday(stuBirthday);
        String engGrade = (String) body.get("engGrade");
        student.setStuEngGrade(engGrade);
        String classId = (String) body.get("classId");
        student.setStuClassId(classId);
        double stuHeight = Double.parseDouble(String.valueOf(body.get("stuHeight")));
        student.setStuHight(new BigDecimal(stuHeight));
        String stuIntro = (String) body.get("stuIntro");
        student.setStuIntro(stuIntro);
        String stuPhone = (String) body.get("stuPhone");
        student.setStuPhone(stuPhone);
        String stuAddr = (String) body.get("stuAddress");
        student.setStuAddress(stuAddr);
        Date stuAdmissionDate = DateUtil.stringToDate((String) body.get("admissionDate"));
        student.setStuAdmissionDate(stuAdmissionDate);
        String studentNamePiny = DBUtil.chineseToPinyin(stuName);
        student.setStuPiny(studentNamePiny);
        return student;
    }

    @PostMapping(value = "/add")
    @ApiOperation(value = "添加学生")
    public ServerResponse<String> addStudent(@RequestBody Map<String, Object> body) {
        try {
            StudentInfoPo student = requestBodyToStudentInfoPo(body);
            return studentService.addStudent(student);
        } catch (Exception e) {
            return ServerResponse.createByErrorMessage("新增失败，内部错误");
        }
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改学生信息")
    public ServerResponse<String> updateStudent(@RequestBody Map<String, Object> body) {
        try {
            StudentInfoPo student = requestBodyToStudentInfoPo(body);
            return studentService.updateStudent(student);
        } catch (Exception e) {
            return ServerResponse.createByErrorMessage("修改失败，内部错误");
        }
    }

    @PostMapping(value = "/search")
    @ApiOperation(value = "根据学号查询学生信息接口（无班级名称）")
    public ServerResponse<StudentInfoVo> getStudentInfo(@RequestParam(value = "studentID") String studentID) {
        try {
            return studentService.searchStudentInfoByID(studentID);
        } catch (Exception e) {
            return ServerResponse.createByErrorMessage("获取失败");
        }
    }

    @PostMapping(value = "/searchWithClassInfo")
    @ApiOperation(value = "根据学号查询学生信息接口（含班级名称）")
    public ServerResponse<StudentInfoVo> getStudentInfoWithClass(@RequestParam(value = "studentID") String studentID) {
        try {
            return studentService.searchStudentInfoWithClassInfoByID(studentID);
        } catch (Exception e) {
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
            return ServerResponse.createByErrorMessage("获取失败");
        }
    }
}
