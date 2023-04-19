package com.example.studentmodule.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName student_info
 */
public class StudentInfoPo implements Serializable {
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
    private Date stuAdmissionDate;

    /**
     * 拼音
     */
    private String stuPiny;

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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        StudentInfoPo other = (StudentInfoPo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStuId() == null ? other.getStuId() == null : this.getStuId().equals(other.getStuId()))
            && (this.getStuName() == null ? other.getStuName() == null : this.getStuName().equals(other.getStuName()))
            && (this.getStuSex() == null ? other.getStuSex() == null : this.getStuSex().equals(other.getStuSex()))
            && (this.getStuBirthday() == null ? other.getStuBirthday() == null : this.getStuBirthday().equals(other.getStuBirthday()))
            && (this.getStuEngGrade() == null ? other.getStuEngGrade() == null : this.getStuEngGrade().equals(other.getStuEngGrade()))
            && (this.getStuClassId() == null ? other.getStuClassId() == null : this.getStuClassId().equals(other.getStuClassId()))
            && (this.getStuHight() == null ? other.getStuHight() == null : this.getStuHight().equals(other.getStuHight()))
            && (this.getStuIntro() == null ? other.getStuIntro() == null : this.getStuIntro().equals(other.getStuIntro()))
            && (this.getStuPhone() == null ? other.getStuPhone() == null : this.getStuPhone().equals(other.getStuPhone()))
            && (this.getStuAddress() == null ? other.getStuAddress() == null : this.getStuAddress().equals(other.getStuAddress()))
            && (this.getStuAdmissionDate() == null ? other.getStuAdmissionDate() == null : this.getStuAdmissionDate().equals(other.getStuAdmissionDate()))
            && (this.getStuPiny() == null ? other.getStuPiny() == null : this.getStuPiny().equals(other.getStuPiny()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStuId() == null) ? 0 : getStuId().hashCode());
        result = prime * result + ((getStuName() == null) ? 0 : getStuName().hashCode());
        result = prime * result + ((getStuSex() == null) ? 0 : getStuSex().hashCode());
        result = prime * result + ((getStuBirthday() == null) ? 0 : getStuBirthday().hashCode());
        result = prime * result + ((getStuEngGrade() == null) ? 0 : getStuEngGrade().hashCode());
        result = prime * result + ((getStuClassId() == null) ? 0 : getStuClassId().hashCode());
        result = prime * result + ((getStuHight() == null) ? 0 : getStuHight().hashCode());
        result = prime * result + ((getStuIntro() == null) ? 0 : getStuIntro().hashCode());
        result = prime * result + ((getStuPhone() == null) ? 0 : getStuPhone().hashCode());
        result = prime * result + ((getStuAddress() == null) ? 0 : getStuAddress().hashCode());
        result = prime * result + ((getStuAdmissionDate() == null) ? 0 : getStuAdmissionDate().hashCode());
        result = prime * result + ((getStuPiny() == null) ? 0 : getStuPiny().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", stuId=").append(stuId);
        sb.append(", stuName=").append(stuName);
        sb.append(", stuSex=").append(stuSex);
        sb.append(", stuBirthday=").append(stuBirthday);
        sb.append(", stuEngGrade=").append(stuEngGrade);
        sb.append(", stuClassId=").append(stuClassId);
        sb.append(", stuHight=").append(stuHight);
        sb.append(", stuIntro=").append(stuIntro);
        sb.append(", stuPhone=").append(stuPhone);
        sb.append(", stuAddress=").append(stuAddress);
        sb.append(", stuAdmissionDate=").append(stuAdmissionDate);
        sb.append(", stuPiny=").append(stuPiny);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}