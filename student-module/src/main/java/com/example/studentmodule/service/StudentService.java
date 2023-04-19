package com.example.studentmodule.service;


import com.example.commonmodule.response.ServerResponse;
import com.example.studentmodule.po.StudentInfoPo;
import com.example.studentmodule.po.StudentInfoPoExt;
import com.example.studentmodule.vo.StudentInfoVo;

public interface StudentService {



    ServerResponse<String> addStudent(StudentInfoPo student);

    ServerResponse<String> updateStudent(StudentInfoPo student);

    ServerResponse<StudentInfoVo> searchStudentInfoByID(String studentID);
    ServerResponse<StudentInfoVo> searchStudentInfoWithClassInfoByID(String studentID);
}
