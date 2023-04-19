package com.example.commonmodule.response;

/**
 * 状态码封装
 */
public enum ResponseCode {

    // 操作成功
    SUCCESS(20000, "操作成功"),
    // 未知异常
    ERROR(50000, "操作失败"),

    ;

    private Integer status;
    private String msg;

    ResponseCode(Integer status, String message) {
        this.status = status;
        this.msg = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}