package com.example.studentmodule.mapper;

import com.example.studentmodule.po.StudentInfoPo;
import com.example.studentmodule.po.StudentInfoPoExt;
import org.apache.ibatis.annotations.Mapper;

/**
* @author yangman
* @description 针对表【student_info】的数据库操作Mapper
* @createDate 2023-04-19 09:23:33
* @Entity com.example.studentmodule.po.StudentInfo
*/
@Mapper
public interface StudentInfoMapper {

    StudentInfoPo selectByID(String studentID);

    int insertStudent(StudentInfoPo student);

    int updateStudent(StudentInfoPo student);

    StudentInfoPoExt selectStudentInfoWithClassInfoByID(String studentID);
}




