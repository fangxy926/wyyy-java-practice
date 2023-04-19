package com.example.studentmodule.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.commonmodule.response.ServerResponse;
import com.example.studentmodule.po.StudentInfoPo;
import com.example.studentmodule.po.StudentInfoPoExt;
import com.example.studentmodule.vo.StudentInfoVo;

import java.util.List;

public interface StudentService {

    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    ServerResponse<String> addStudent(StudentInfoPo student);

    /**
     * 修改学生信息
     *
     * @param student
     * @return
     */
    ServerResponse<String> updateStudent(StudentInfoPo student);

    /**
     * 根据学号查询学生信息接口（无班级名称）
     *
     * @param studentID
     * @return
     */
    ServerResponse<StudentInfoVo> searchStudentInfoByID(String studentID);

    /**
     * 根据学号查询学生信息接口（含班级名称）
     *
     * @param studentID
     * @return
     */
    ServerResponse<StudentInfoVo> searchStudentInfoWithClassInfoByID(String studentID);

    /**
     * 根据班级代码获取班级所有学生的信息
     *
     * @param classID
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<IPage<StudentInfoVo>> pageListByClass(String classID, int pageNum, int pageSize);

    /**
     * pageListOrderByAge
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<IPage<StudentInfoVo>> pageListOrderByAge(int pageNum, int pageSize, String order);
}
