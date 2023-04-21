package com.example.commonmodule.enums;

/**
 * 英语等级枚举类
 */
public enum EngGrade {
    FOUR_DEGREE("4级"),
    SIX_DEGREE("6级");

    private String name;

    private EngGrade(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
