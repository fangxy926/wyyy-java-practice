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
 * @createDate 2023-04-20 10:08:14
 * @Entity com.example.courseselectmodule.po.StudentCourseInfoPo
 */
@Mapper
public interface StudentCourseInfoMapper {

    List<StudentInfoPo> selectByCourse(CourseInfoDto courseInfoDto);

    int countStudents(String courseId);

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
     * @param item
     * @return
     */
    int insert(StudentCourseInfoDto studentCourseInfoDto);
}
