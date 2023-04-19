package com.example.studentmodule.po;

import java.io.Serializable;

public class StudentInfoPoExt extends StudentInfoPo implements Serializable {

    /**
     * 班级信息
     */
    private ClassInfoPo classInfoPo;


    public ClassInfoPo getClassInfoPo() {
        return classInfoPo;
    }

    public void setClassInfoPo(ClassInfoPo classInfoPo) {
        this.classInfoPo = classInfoPo;
    }
}
