package com.example.commonmodule.enums;

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