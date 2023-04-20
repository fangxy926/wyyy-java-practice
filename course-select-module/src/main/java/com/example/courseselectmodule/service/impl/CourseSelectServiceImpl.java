package com.example.courseselectmodule.service.impl;

import com.example.commonmodule.enums.WeekDay;
import com.example.commonmodule.response.ServerResponse;
import com.example.commonmodule.utils.DateUtil;
import com.example.courseselectmodule.dto.CourseInfoDto;
import com.example.courseselectmodule.dto.CourseSchedule;
import com.example.courseselectmodule.dto.StudentCourseInfoDto;
import com.example.courseselectmodule.dto.StudentSelectedCourseDto;
import com.example.courseselectmodule.mapper.CourseInfoMapper;
import com.example.courseselectmodule.mapper.StudentCourseInfoMapper;
import com.example.courseselectmodule.po.CourseInfoPo;
import com.example.courseselectmodule.service.CourseSelectService;
import com.example.courseselectmodule.vo.CourseInfoVo;
import com.example.studentmodule.dto.StudentInfoDto;
import com.example.studentmodule.po.StudentInfoPo;
import com.example.studentmodule.vo.StudentInfoVo;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class CourseSelectServiceImpl implements CourseSelectService {

    @Autowired
    private CourseInfoMapper courseInfoMapper;

    @Autowired
    private StudentCourseInfoMapper studentCourseInfoPoMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 初始化星期枚举映射表
     */
    private static final Map<Integer, WeekDay> weekDayMap = new HashMap<>();

    static {
        for (WeekDay weekDay : WeekDay.values()) {
            weekDayMap.put(weekDay.getValue(), weekDay);
        }
    }

    @Override
    public ServerResponse<String> submitSelection(StudentSelectedCourseDto studentSelectedCourseDto) {
        StudentInfoDto studentInfo = studentSelectedCourseDto.getStudentInfo();
        List<CourseInfoDto> courseList = studentSelectedCourseDto.getCourseList();

        // 校验课程是否存在已选的课程
        Set<String> courseSet = courseList.stream()
                .map(CourseInfoDto::getCourseId)
                .collect(Collectors.toSet());
        if (courseSet.size() != courseList.size()) {
            return ServerResponse.createByErrorMessage("存在重复选报的课程");
        }
        int count = studentCourseInfoPoMapper.checkExist(studentInfo, courseList);
        if (count > 0) {
            return ServerResponse.createByErrorMessage("存在重复选报的课程");
        }
        // 校验选课数上限
        int courseCount = studentCourseInfoPoMapper.countCourse(studentInfo.getStuId());
        if (courseList.size() > 2 || courseCount + courseList.size() > 2) {
            return ServerResponse.createByErrorMessage("每个学生最多只能报选2门选修课");
        }
        // 校验课程最大报选人数上限
        for (CourseInfoDto courseInfoDto : courseList) {
            int limit = courseInfoDto.getCourseLimit();
            int studentCount = studentCourseInfoPoMapper.countStudents(courseInfoDto.getCourseId());
            if (studentCount + 1 > limit) {
                return ServerResponse.createByErrorMessage("超出课程人数容量上限！");
            }
        }
        // 校验时间是否有交集
        // 获取已选课程信息
        List<CourseInfoPo> selectedCourse = courseInfoMapper.selectCourseListByStudentId(studentInfo.getStuId());
        // 将Dto和Po统一封装为CourseSchedule对象
        List<CourseSchedule> courseSchedules = new ArrayList<>();
        for (CourseInfoPo course : selectedCourse) {
            CourseSchedule cs = new CourseSchedule(course.getCourseWeekDay(),
                    DateUtil.dateToLocalTime(course.getCourseStartTime()),
                    DateUtil.dateToLocalTime(course.getCourseEndTime()));
            courseSchedules.add(cs);
        }
        for (CourseInfoDto course : courseList) {
            CourseSchedule cs = new CourseSchedule(course.getCourseWeekDay(),
                    DateUtil.dateToLocalTime(course.getCourseStartTime()),
                    DateUtil.dateToLocalTime(course.getCourseEndTime()));
            courseSchedules.add(cs);
        }
        if (CourseSchedule.hasConflict(courseSchedules)) {
            return ServerResponse.createByErrorMessage("上课时间存在冲突！");
        }

        // 校验通过，正常插入选课，采用批量插入方式
        List<StudentCourseInfoDto> studentCourseInfoDtos = new ArrayList<>();
        for (CourseInfoDto courseInfoDto : courseList) {
            StudentCourseInfoDto dto = new StudentCourseInfoDto();
            dto.setStuId(studentInfo.getStuId());
            dto.setCourseId(courseInfoDto.getCourseId());
            studentCourseInfoDtos.add(dto);
        }
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        StudentCourseInfoMapper sm = sqlSession.getMapper(StudentCourseInfoMapper.class);
        for (StudentCourseInfoDto dto : studentCourseInfoDtos) {
            sm.insert(dto);
        }
        sqlSession.commit();

//        int cnt = studentCourseInfoPoMapper.batchInsert(studentCourseInfoDtos);

        return ServerResponse.createBySuccessMessage("选课成功");
    }


    private String getCourseTimeString(Integer week, Date st, Date et) {
        return weekDayMap.get(week) + " "
                + DateUtil.getHourMinute(st) + " - "
                + DateUtil.getHourMinute(et);
    }


    @Override
    public ServerResponse<List<CourseInfoVo>> listByStudentId(String studentId) {
        List<CourseInfoPo> pos = courseInfoMapper.selectCourseListByStudentId(studentId);
        List<CourseInfoVo> vos = new ArrayList<>();
        for (CourseInfoPo po : pos) {
            CourseInfoVo vo = new CourseInfoVo();
            vo.setCourseId(po.getCourseId());
            vo.setCourseName(po.getCourseName());
            vo.setCourseTimeRange(this.getCourseTimeString(po.getCourseWeekDay(),
                    po.getCourseStartTime(), po.getCourseEndTime()));
            vos.add(vo);
        }
        return ServerResponse.createBySuccess("获取成功", vos);
    }

    @Override
    public ServerResponse<CourseInfoVo> getCourseInfo(CourseInfoDto courseInfoDto) {
        CourseInfoPo po = courseInfoMapper.selectCourse(courseInfoDto);
        // 根据课程ID查询选修学生数量
        CourseInfoVo vo = courseInfoPo2Vo(po);
        return ServerResponse.createBySuccess("获取成功", vo);
    }

    @Override
    public ServerResponse<List<CourseInfoVo>> batchListCourseInfo(List<String> courseIdList) {
        List<CourseInfoPo> courseInfoPos = courseInfoMapper.batchSelectCourse(courseIdList);
        List<CourseInfoVo> courseInfoVos = new ArrayList<>();
        for (CourseInfoPo po : courseInfoPos) {
            CourseInfoVo vo = courseInfoPo2Vo(po);
            courseInfoVos.add(vo);
        }
        return ServerResponse.createBySuccess("获取成功", courseInfoVos);
    }

    @Override
    public ServerResponse<List<StudentInfoVo>> listStudentInfo(CourseInfoDto courseInfoDto) {
        List<StudentInfoPo> studentInfoPos = studentCourseInfoPoMapper.selectByCourse(courseInfoDto);
        List<StudentInfoVo> studentInfoVos = new ArrayList<>();
        for (StudentInfoPo po : studentInfoPos) {
            StudentInfoVo vo = new StudentInfoVo();
            vo.setStuId(po.getStuId());
            vo.setStuName(po.getStuName());
            vo.setStuSex(po.getStuSex());
            vo.setStuBirthday(po.getStuBirthday());
            vo.setStuEngGrade(po.getStuEngGrade());
            vo.setStuClassId(po.getStuClassId());
            vo.setStuHeight(po.getStuHeight());
            vo.setStuPhone(po.getStuPhone());
            vo.setStuAdmissionDate(po.getStuAdmissionDate());
            vo.setStuAddress(po.getStuAddress());
            studentInfoVos.add(vo);
        }
        return ServerResponse.createBySuccess("获取成功", studentInfoVos);
    }

    /**
     * po转vo
     *
     * @param po
     * @return
     */
    private CourseInfoVo courseInfoPo2Vo(CourseInfoPo po) {
        CourseInfoVo vo = new CourseInfoVo();
        vo.setCourseId(po.getCourseId());
        vo.setCourseName(po.getCourseName());
        int studentCount = studentCourseInfoPoMapper.countStudents(po.getCourseId());
        vo.setCourseSelected(studentCount);
        vo.setCourseRemain(vo.getCourseLimit() - vo.getCourseSelected());
        vo.setCourseLimit(po.getCourseLimit());
        vo.setCourseTimeRange(this.getCourseTimeString(po.getCourseWeekDay(),
                po.getCourseStartTime(), po.getCourseEndTime()));
        return vo;
    }
}
