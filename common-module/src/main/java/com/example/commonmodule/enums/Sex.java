package com.example.commonmodule.enums;

/**
 * 性别枚举类
 */
public enum Sex {
    MALE("男"),
    FEMALE("女");

    private String name;

    private Sex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
