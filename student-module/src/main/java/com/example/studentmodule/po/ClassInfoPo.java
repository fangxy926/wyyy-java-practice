package com.example.studentmodule.po;

import java.io.Serializable;

/**
 * 
 * @TableName class_info
 */
public class ClassInfoPo implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 班级代码
     */
    private String classId;

    /**
     * 班级名称
     */
    private String className;

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
     * 班级代码
     */
    public String getClassId() {
        return classId;
    }

    /**
     * 班级代码
     */
    public void setClassId(String classId) {
        this.classId = classId;
    }

    /**
     * 班级名称
     */
    public String getClassName() {
        return className;
    }

    /**
     * 班级名称
     */
    public void setClassName(String className) {
        this.className = className;
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
        ClassInfoPo other = (ClassInfoPo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClassId() == null ? other.getClassId() == null : this.getClassId().equals(other.getClassId()))
            && (this.getClassName() == null ? other.getClassName() == null : this.getClassName().equals(other.getClassName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getClassId() == null) ? 0 : getClassId().hashCode());
        result = prime * result + ((getClassName() == null) ? 0 : getClassName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", classId=").append(classId);
        sb.append(", className=").append(className);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}