package com.example.studentmodule.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.studentmodule.dto.StudentInfoDto;
import com.example.studentmodule.po.StudentInfoPo;
import com.example.studentmodule.po.StudentInfoPoExt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yangman
 * @description 针对表【student_info】的数据库操作Mapper
 * @createDate 2023-04-19 09:23:33
 * @Entity com.example.studentmodule.po.StudentInfo
 */
@Mapper
public interface StudentInfoMapper extends BaseMapper<StudentInfoPo> {

    StudentInfoPo selectByID(String studentID);

    int insertStudent(StudentInfoDto student);

    int updateStudent(StudentInfoDto student);

    StudentInfoPoExt selectStudentInfoWithClassInfoByID(String studentID);

    /**
     * 根据班级代码获取班级所有学生信息（分页）
     *
     * @param page
     * @param classID
     * @return
     */
    IPage<StudentInfoPo> selectPageByClass(IPage<StudentInfoPo> page, @Param("classID") String classID);

    /**
     * 按照年龄排序获取所有学生列表数据（分页）
     *
     * @param page
     * @param queryWrapper
     * @return
     */
    IPage<StudentInfoPo> selectPage(IPage<StudentInfoPo> page, @Param(Constants.WRAPPER) QueryWrapper<StudentInfoPo> queryWrapper);


    /**
     * 合法学生校验
     *
     * @param studentInfoDto
     * @return
     */
    int validateStudent(StudentInfoDto studentInfoDto);
}




