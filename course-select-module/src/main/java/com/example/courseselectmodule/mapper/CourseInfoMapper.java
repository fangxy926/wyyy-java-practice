package com.example.courseselectmodule.mapper;

import com.example.courseselectmodule.dto.CourseInfoDto;
import com.example.courseselectmodule.po.CourseInfoPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangman
 * @description 针对表【course_info(选修课程信息表)】的数据库操作Mapper
 * @createDate 2023-04-20 10:07:39
 * @Entity com.example.courseselectmodule.po.CourseInfo
 */
@Mapper
public interface CourseInfoMapper {

    List<CourseInfoPo> selectCourseListByStudentId(@Param("studentId") String studentId);

    CourseInfoPo selectCourse(CourseInfoDto courseInfoDto);

    List<CourseInfoPo> batchSelectCourse(@Param("courseIdList") List<String> courseIdList);

    int validateCourseList(List<String> courseIdList);
}
