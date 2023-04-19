package com.example.studentmodule.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.studentmodule.po.StudentInfoPo;
import com.example.studentmodule.po.StudentInfoPoExt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.reflection.wrapper.BaseWrapper;

import java.util.List;

/**
 * @author yangman
 * @description 针对表【student_info】的数据库操作Mapper
 * @createDate 2023-04-19 09:23:33
 * @Entity com.example.studentmodule.po.StudentInfo
 */
@Mapper
public interface StudentInfoMapper extends BaseMapper<StudentInfoPo> {

    StudentInfoPo selectByID(String studentID);

    int insertStudent(StudentInfoPo student);

    int updateStudent(StudentInfoPo student);

    StudentInfoPoExt selectStudentInfoWithClassInfoByID(String studentID);

    /**
     * 根据班级代码获取班级所有学生信息（分页）
     *
     * @param page
     * @param classID
     * @return
     */
    IPage<StudentInfoPo> selectPageByClass(IPage<StudentInfoPo> page, @Param("classID") String classID);

    IPage<StudentInfoPo> selectPage(IPage<StudentInfoPo> page, @Param(Constants.WRAPPER) QueryWrapper<StudentInfoPo> queryWrapper);
}




