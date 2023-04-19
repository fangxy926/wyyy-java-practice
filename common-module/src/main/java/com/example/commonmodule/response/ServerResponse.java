package com.example.commonmodule.response;
/**
 * 通用的API返回接口封装
 */

import java.io.Serializable;

public class ServerResponse<T> implements Serializable {

    private Integer status; //状态码
    private String msg; // 返回内容
    private T data; //返回数据

    /**
     * 构造一个有状态的API返回
     *
     * @param status
     */
    private ServerResponse(Integer status) {
        this.status = status;
    }

    /**
     * 构造一个有状态且带数据的API返回
     *
     * @param status
     * @param data
     */
    private ServerResponse(Integer status, T data) {
        this.status = status;
        this.data = data;
    }

    /**
     * 构造一个全参API返回
     *
     * @param status
     * @param msg
     * @param data
     */
    private ServerResponse(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 构造一个有状态和消息的API返回
     *
     * @param status
     * @param msg
     */
    private ServerResponse(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return this.status.equals(ResponseCode.SUCCESS.getStatus());
    }

    public int getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }


    public static <T> ServerResponse<T> createBySuccessMessage(String msg) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getStatus(), msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getStatus(), data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg, T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getStatus(), msg, data);
    }

    public static <T> ServerResponse<T> createByError() {
        return new ServerResponse<T>(ResponseCode.ERROR.getStatus(), ResponseCode.ERROR.getMsg());
    }


    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage) {
        return new ServerResponse<T>(ResponseCode.ERROR.getStatus(), errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
        return new ServerResponse<T>(errorCode, errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorCode(int errorCode) {
        return new ServerResponse<T>(errorCode);
    }
}
