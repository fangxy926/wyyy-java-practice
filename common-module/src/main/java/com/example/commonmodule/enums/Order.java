package com.example.commonmodule.enums;

/**
 * @Description: 数据库排序枚举类
 * @Author: wwr
 * @Date: 2018/12/10
 */
public enum Order {

    ASC("asc"), DESC("desc");

    private String des;

    Order(String des) {
        this.des = des;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
