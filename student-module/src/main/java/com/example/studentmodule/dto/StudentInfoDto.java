package com.example.studentmodule.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @TableName student_info
 */
public class StudentInfoDto implements Serializable {
    /**
     *
     */
    private Long id;

    /**
     * 学号
     */
    private String stuId;

    /**
     * 姓名
     */
    private String stuName;

    /**
     * 性别
     */
    private String stuSex;

    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date stuBirthday;

    /**
     * 英语等级
     */
    private String stuEngGrade;

    /**
     * 班级代码
     */
    private String stuClassId;

    /**
     * 身高
     */
    private BigDecimal stuHeight;

    /**
     * 自我介绍
     */
    private String stuIntro;

    /**
     * 手机号码
     */
    private String stuPhone;

    /**
     * 联系地址
     */
    private String stuAddress;

    /**
     * 入学日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date stuAdmissionDate;

    /**
     * 拼音
     */
    private String stuPiny;

    private static final long serialVersionUID = 1L;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public Date getStuBirthday() {
        return stuBirthday;
    }

    public void setStuBirthday(Date stuBirthday) {
        this.stuBirthday = stuBirthday;
    }

    public String getStuEngGrade() {
        return stuEngGrade;
    }

    public void setStuEngGrade(String stuEngGrade) {
        this.stuEngGrade = stuEngGrade;
    }

    public String getStuClassId() {
        return stuClassId;
    }

    public void setStuClassId(String stuClassId) {
        this.stuClassId = stuClassId;
    }

    public BigDecimal getStuHeight() {
        return stuHeight;
    }

    public void setStuHeight(BigDecimal stuHeight) {
        this.stuHeight = stuHeight;
    }

    public String getStuIntro() {
        return stuIntro;
    }

    public void setStuIntro(String stuIntro) {
        this.stuIntro = stuIntro;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    public Date getStuAdmissionDate() {
        return stuAdmissionDate;
    }

    public void setStuAdmissionDate(Date stuAdmissionDate) {
        this.stuAdmissionDate = stuAdmissionDate;
    }

    public String getStuPiny() {
        return stuPiny;
    }

    public void setStuPiny(String stuPiny) {
        this.stuPiny = stuPiny;
    }
}