package com.example.studentmodule.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @TableName student_info
 */
public class StudentInfoVo implements Serializable {
    private Long id;

    @ApiModelProperty(value = "学号", example = "2010001")
    private String stuId;


    @ApiModelProperty(value = "学生姓名", example = "张三")
    private String stuName;


    @ApiModelProperty(value = "性别", example = "男")
    private String stuSex;

    @ApiModelProperty(value = "出生日期", example = "1998-01-01")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date stuBirthday;

    @ApiModelProperty(value = "英语等级", example = "4级")
    private String stuEngGrade;

    @ApiModelProperty(value = "班级代码", example = "C01")
    private String stuClassId;

    @ApiModelProperty(value = "身高", example = "178.5", dataType = "java.math.BigDecimal")
    private BigDecimal stuHeight;


    @ApiModelProperty(value = "自我介绍")
    private String stuIntro;

    @ApiModelProperty(value = "手机号码", example = "15912345678")
    private String stuPhone;

    @ApiModelProperty(value = "联系地址")
    private String stuAddress;

    @ApiModelProperty(value = "入学日期", example = "2022-09-01")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date stuAdmissionDate;

    @ApiModelProperty(value = "拼音", example = "zhangsan")
    private String stuPiny;

    @ApiModelProperty(value = "班级名", example = "班级01")
    private String stuClassName;

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

    public String getStuClassName() {
        return stuClassName;
    }

    public void setStuClassName(String stuClassName) {
        this.stuClassName = stuClassName;
    }
}