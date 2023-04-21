package com.example.courseselectmodule.mapper;

import com.example.courseselectmodule.dto.CourseInfoDto;
import com.example.courseselectmodule.po.CourseInfoPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangman
 * @description 针对表【course_info(选修课程信息表)】的数据库操作Mapper
 */
@Mapper
public interface CourseInfoMapper {

    /**
     * 根据学号查询报课信息
     *
     * @param studentId
     * @return
     */
    List<CourseInfoPo> selectCourseListByStudentId(@Param("studentId") String studentId);

    /**
     * 查询课程信息
     *
     * @param courseInfoDto
     * @return
     */
    CourseInfoPo selectCourse(CourseInfoDto courseInfoDto);

    /**
     * 根据课程ID列表查询课程信息
     *
     * @param courseIdList
     * @return
     */

    List<CourseInfoPo> batchSelectCourse(@Param("courseIdList") List<String> courseIdList);

    /**
     * 合法课程验证
     *
     * @param courseIdList
     * @return
     */
    int validateCourseList(List<String> courseIdList);
}
