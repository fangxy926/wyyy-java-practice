package com.example.studentmodule.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.commonmodule.response.ServerResponse;
import com.example.studentmodule.mapper.StudentInfoMapper;
import com.example.studentmodule.po.StudentInfoPo;
import com.example.studentmodule.po.StudentInfoPoExt;
import com.example.studentmodule.service.StudentService;
import com.example.studentmodule.util.ValidUtil;
import com.example.studentmodule.vo.StudentInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentInfoMapper studentInfoMapper;

    @Override
    @Cacheable(cacheNames = "student_info_cache", keyGenerator = "apiKeyGenerator")
    public ServerResponse<StudentInfoVo> searchStudentInfoByID(String studentID) {
        StudentInfoPo studentInfoPo = studentInfoMapper.selectByID(studentID);
        StudentInfoVo vo = new StudentInfoVo();
        if (studentInfoPo != null) {
            vo.setStuId(studentInfoPo.getStuId());
            vo.setStuName(studentInfoPo.getStuName());
            vo.setStuSex(studentInfoPo.getStuSex());
            vo.setStuBirthday(studentInfoPo.getStuBirthday());
            vo.setStuEngGrade(studentInfoPo.getStuEngGrade());
            vo.setStuClassId(studentInfoPo.getStuClassId());
            vo.setStuHight(studentInfoPo.getStuHight());
            vo.setStuPhone(studentInfoPo.getStuPhone());
            vo.setStuAdmissionDate(studentInfoPo.getStuAdmissionDate());
            vo.setStuAddress(studentInfoPo.getStuAddress());
        }
        return ServerResponse.createBySuccess(vo);
    }

    @Override
    @Cacheable(cacheNames = "student_info_cache", keyGenerator = "apiKeyGenerator")
    public ServerResponse<StudentInfoVo> searchStudentInfoWithClassInfoByID(String studentID) {
        StudentInfoPoExt poExt = studentInfoMapper.selectStudentInfoWithClassInfoByID(studentID);
        StudentInfoVo vo = new StudentInfoVo();
        if (poExt != null) {
            vo.setStuId(poExt.getStuId());
            vo.setStuName(poExt.getStuName());
            vo.setStuSex(poExt.getStuSex());
            vo.setStuBirthday(poExt.getStuBirthday());
            vo.setStuEngGrade(poExt.getStuEngGrade());
            vo.setStuClassId(poExt.getStuClassId());
            vo.setStuHight(poExt.getStuHight());
            vo.setStuPhone(poExt.getStuPhone());
            vo.setStuAdmissionDate(poExt.getStuAdmissionDate());
            vo.setStuAddress(poExt.getStuAddress());
            vo.setStuClassName(poExt.getClassInfoPo().getClassName());
        }
        return ServerResponse.createBySuccess("获取成功", vo);
    }

    @Override
    public ServerResponse<IPage<StudentInfoVo>> pageListByClass(String classID, int pageNum, int pageSize) {
        IPage<StudentInfoPo> page = studentInfoMapper.selectPageByClass(Page.of(pageNum, pageSize), classID);
        // 利用page.convert方法实现Do到Vo的转换
        IPage<StudentInfoVo> vos = page.convert(po -> {
            StudentInfoVo vo = new StudentInfoVo();
            vo.setStuId(po.getStuId());
            vo.setStuName(po.getStuName());
            vo.setStuSex(po.getStuSex());
            vo.setStuBirthday(po.getStuBirthday());
            vo.setStuEngGrade(po.getStuEngGrade());
            vo.setStuClassId(po.getStuClassId());
            vo.setStuHight(po.getStuHight());
            vo.setStuPhone(po.getStuPhone());
            vo.setStuAdmissionDate(po.getStuAdmissionDate());
            vo.setStuAddress(po.getStuAddress());
            return vo;
        });
        return ServerResponse.createBySuccess("获取成功", vos);
    }

    @Override
    public ServerResponse<IPage<StudentInfoVo>> pageListOrderByAge(int pageNum, int pageSize, String order) {
        QueryWrapper<StudentInfoPo> queryWrapper = new QueryWrapper<>();
        // 根据年龄排序
        if ("asc".equals(order)) {
            queryWrapper.orderByAsc(" TIMESTAMPDIFF(YEAR, stu_birthday, CURDATE())");
        } else {
            queryWrapper.orderByDesc(" TIMESTAMPDIFF(YEAR, stu_birthday, CURDATE())");
        }
        // 根据学号升序
        queryWrapper.lambda().orderByAsc(StudentInfoPo::getStuId);
        IPage<StudentInfoPo> pageData = studentInfoMapper.selectPage(Page.of(pageNum, pageSize), queryWrapper);
        // 利用page.convert方法实现Do到Vo的转换
        IPage<StudentInfoVo> vos = pageData.convert(po -> {
            StudentInfoVo vo = new StudentInfoVo();
            vo.setStuId(po.getStuId());
            vo.setStuName(po.getStuName());
            vo.setStuSex(po.getStuSex());
            vo.setStuBirthday(po.getStuBirthday());
            vo.setStuEngGrade(po.getStuEngGrade());
            vo.setStuClassId(po.getStuClassId());
            vo.setStuHight(po.getStuHight());
            vo.setStuPhone(po.getStuPhone());
            vo.setStuAdmissionDate(po.getStuAdmissionDate());
            vo.setStuAddress(po.getStuAddress());
            return vo;
        });
        return ServerResponse.createBySuccess("获取成功", vos);
    }

    private ServerResponse<String> validStudentInfoCheck(StudentInfoPo student) {
        if (!ValidUtil.validStudentID(student.getStuId())) {
            return ServerResponse.createByErrorMessage("学号格式错误！");
        }
        if (!ValidUtil.validPhone(student.getStuPhone())) {
            return ServerResponse.createByErrorMessage("手机号码格式错误！");
        }
        if (!ValidUtil.validLength(student.getStuIntro(), 50)) {
            return ServerResponse.createByErrorMessage("自我介绍长度超出50字符限制！");
        }
        if (!ValidUtil.validLength(student.getStuAddress(), 50)) {
            return ServerResponse.createByErrorMessage("联系地址长度超出50字符限制！");
        }
        if (!ValidUtil.validEngGrade(student.getStuEngGrade())) {
            return ServerResponse.createByErrorMessage("非法英语等级！");
        }
        if (!ValidUtil.validBirthDayAndAdmissionDate(student.getStuBirthday())) {
            return ServerResponse.createByErrorMessage("非法出生日期！");
        }
        if (!ValidUtil.validBirthDayAndAdmissionDate(student.getStuAdmissionDate())) {
            return ServerResponse.createByErrorMessage("非法入学日期！");
        }
        if (!ValidUtil.validSex(student.getStuSex())) {
            return ServerResponse.createByErrorMessage("性别有误！");
        }
        return ServerResponse.createBySuccessMessage("校验成功");
    }

    @Override
    public ServerResponse<String> addStudent(StudentInfoPo student) {
        // 插入前校验
        ServerResponse<String> checkRes = validStudentInfoCheck(student);
        if (!checkRes.isSuccess()) return checkRes;

        int cnt = studentInfoMapper.insertStudent(student);
        return cnt > 0 ? ServerResponse.createBySuccess("添加成功") :
                ServerResponse.createByErrorMessage("添加失败");
    }

    @Override
    public ServerResponse<String> updateStudent(StudentInfoPo student) {
        // 修改前校验
        ServerResponse<String> checkRes = validStudentInfoCheck(student);
        if (!checkRes.isSuccess()) return checkRes;

        int cnt = studentInfoMapper.updateStudent(student);
        return cnt > 0 ? ServerResponse.createBySuccess("修改成功") :
                ServerResponse.createByErrorMessage("修改失败");
    }
}
