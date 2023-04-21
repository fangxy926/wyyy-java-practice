package com.example.courseselectmodule.mapper;

import com.example.courseselectmodule.dto.CourseInfoDto;
import com.example.courseselectmodule.dto.StudentCourseInfoDto;
import com.example.studentmodule.dto.StudentInfoDto;
import com.example.studentmodule.po.StudentInfoPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangman
 * @description 针对表【student_course_info(学生选课结果表)】的数据库操作Mapper
 */
@Mapper
public interface StudentCourseInfoMapper {
    /**
     * 查询报选课程的学生信息
     *
     * @param courseInfoDto
     * @return
     */

    List<StudentInfoPo> selectByCourse(CourseInfoDto courseInfoDto);

    /**
     * 统计课程的报名数
     *
     * @param courseId
     * @return
     */

    int countStudents(String courseId);

    /**
     * 统计学生的选课数
     *
     * @param stuId
     * @return
     */
    int countCourse(String stuId);

    int checkExist(@Param("studentInfo") StudentInfoDto studentInfo, @Param("courseList") List<CourseInfoDto> courseList);

    /**
     * 批量插入选课结果
     *
     * @param studentCourseInfoDtos
     * @return
     */
    int batchInsert(@Param("studentCourseList") List<StudentCourseInfoDto> studentCourseInfoDtos);

    /**
     * 插入一条选课结果
     *
     * @param studentCourseInfoDto
     * @return
     */
    int insert(StudentCourseInfoDto studentCourseInfoDto);
}
