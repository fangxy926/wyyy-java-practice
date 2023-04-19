package com.example.studentmodule.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @TableName student_info
 */
public class StudentInfoVo implements Serializable {
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
    private BigDecimal stuHight;

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


    /**
     * 班级信息
     */
    private String stuClassName;

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public Long getId() {
        return id;
    }

    /**
     *
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 学号
     */
    public String getStuId() {
        return stuId;
    }

    /**
     * 学号
     */
    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    /**
     * 姓名
     */
    public String getStuName() {
        return stuName;
    }

    /**
     * 姓名
     */
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    /**
     * 性别
     */
    public String getStuSex() {
        return stuSex;
    }

    /**
     * 性别
     */
    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    /**
     * 出生日期
     */
    public Date getStuBirthday() {
        return stuBirthday;
    }

    /**
     * 出生日期
     */
    public void setStuBirthday(Date stuBirthday) {
        this.stuBirthday = stuBirthday;
    }

    /**
     * 英语等级
     */
    public String getStuEngGrade() {
        return stuEngGrade;
    }

    /**
     * 英语等级
     */
    public void setStuEngGrade(String stuEngGrade) {
        this.stuEngGrade = stuEngGrade;
    }

    /**
     * 班级代码
     */
    public String getStuClassId() {
        return stuClassId;
    }

    /**
     * 班级代码
     */
    public void setStuClassId(String stuClassId) {
        this.stuClassId = stuClassId;
    }

    /**
     * 身高
     */
    public BigDecimal getStuHight() {
        return stuHight;
    }

    /**
     * 身高
     */
    public void setStuHight(BigDecimal stuHight) {
        this.stuHight = stuHight;
    }

    /**
     * 自我介绍
     */
    public String getStuIntro() {
        return stuIntro;
    }

    /**
     * 自我介绍
     */
    public void setStuIntro(String stuIntro) {
        this.stuIntro = stuIntro;
    }

    /**
     * 手机号码
     */
    public String getStuPhone() {
        return stuPhone;
    }

    /**
     * 手机号码
     */
    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    /**
     * 联系地址
     */
    public String getStuAddress() {
        return stuAddress;
    }

    /**
     * 联系地址
     */
    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    /**
     * 入学日期
     */
    public Date getStuAdmissionDate() {
        return stuAdmissionDate;
    }

    /**
     * 入学日期
     */
    public void setStuAdmissionDate(Date stuAdmissionDate) {
        this.stuAdmissionDate = stuAdmissionDate;
    }

    /**
     * 拼音
     */
    public String getStuPiny() {
        return stuPiny;
    }

    /**
     * 拼音
     */
    public void setStuPiny(String stuPiny) {
        this.stuPiny = stuPiny;
    }

    public String getStuClassName() {
        return stuClassName;
    }

    public void setStuClassName(String stuClassName) {
        this.stuClassName = stuClassName;
    }
}