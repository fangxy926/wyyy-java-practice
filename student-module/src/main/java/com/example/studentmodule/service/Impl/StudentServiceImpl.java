package com.example.studentmodule.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.commonmodule.response.ServerResponse;
import com.example.studentmodule.dto.StudentInfoDto;
import com.example.studentmodule.mapper.StudentInfoMapper;
import com.example.studentmodule.po.StudentInfoPo;
import com.example.studentmodule.po.StudentInfoPoExt;
import com.example.studentmodule.service.StudentService;
import com.example.studentmodule.util.DBUtil;
import com.example.studentmodule.util.ValidUtil;
import com.example.studentmodule.vo.StudentInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentInfoMapper studentInfoMapper;

    private ServerResponse<String> validStudentInfoCheck(StudentInfoDto student) {
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

    /**
     * dto 转 po
     *
     * @param dto
     * @return
     */
    private StudentInfoPo convertStudentInfoDto2Po(StudentInfoDto dto) {
        StudentInfoPo po = new StudentInfoPo();
        po.setStuId(dto.getStuId());
        po.setStuName(dto.getStuName());
        po.setStuSex(dto.getStuSex());
        po.setStuBirthday(dto.getStuBirthday());
        po.setStuEngGrade(dto.getStuEngGrade());
        po.setStuClassId(dto.getStuClassId());
        po.setStuHeight(dto.getStuHeight());
        po.setStuIntro(dto.getStuIntro());
        po.setStuPhone(dto.getStuPhone());
        po.setStuAddress(dto.getStuAddress());
        po.setStuAdmissionDate(dto.getStuAdmissionDate());
        po.setStuPiny(DBUtil.chineseToPinyin(dto.getStuName()));
        return po;
    }

    /**
     * po 转 vo
     *
     * @param po
     * @return
     */
    private StudentInfoVo convertStudentInfoPo2Vo(StudentInfoPo po) {
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
        return vo;
    }

    @Override
    @Cacheable(cacheNames = "student_info_cache", keyGenerator = "apiKeyGenerator")
    public ServerResponse<StudentInfoVo> searchStudentInfoByID(String studentID) {
        StudentInfoPo studentInfoPo = studentInfoMapper.selectByID(studentID);
        StudentInfoVo vo = new StudentInfoVo();
        if (studentInfoPo != null) {
            vo = convertStudentInfoPo2Vo(studentInfoPo);
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
            vo.setStuHeight(poExt.getStuHeight());
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
        IPage<StudentInfoVo> vos = page.convert(this::convertStudentInfoPo2Vo);
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
        IPage<StudentInfoVo> vos = pageData.convert(this::convertStudentInfoPo2Vo);
        return ServerResponse.createBySuccess("获取成功", vos);
    }


    @Override
    public ServerResponse<String> addStudent(StudentInfoDto studentDto) {
        // 插入前校验
        ServerResponse<String> checkRes = validStudentInfoCheck(studentDto);
        if (!checkRes.isSuccess()) return checkRes;

        int cnt = studentInfoMapper.insertStudent(convertStudentInfoDto2Po(studentDto));
        return cnt > 0 ? ServerResponse.createBySuccess("添加成功") :
                ServerResponse.createByErrorMessage("添加失败");
    }

    @Override
    public ServerResponse<String> updateStudent(StudentInfoDto studentDto) {
        // 修改前校验
        ServerResponse<String> checkRes = validStudentInfoCheck(studentDto);
        if (!checkRes.isSuccess()) return checkRes;

        int cnt = studentInfoMapper.updateStudent(convertStudentInfoDto2Po(studentDto));
        return cnt > 0 ? ServerResponse.createBySuccess("修改成功") :
                ServerResponse.createByErrorMessage("修改失败");
    }
}
