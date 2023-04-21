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
 */
@Mapper
public interface StudentInfoMapper extends BaseMapper<StudentInfoPo> {

    /**
     * 根据学生id查询学生信息
     * @param studentID
     * @return
     */
    StudentInfoPo selectByID(String studentID);

    /**
     * 新增学生
     * @param student
     * @return
     */
    int insertStudent(StudentInfoDto student);

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    int updateStudent(StudentInfoDto student);

    /**
     * 根据学号查询学生信息接口（含班级名称）
     * @param studentID
     * @return
     */
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

    /**
     * 学号冲突检查
     * @param stuId
     * @return
     */
    int checkExist(String stuId);
}




