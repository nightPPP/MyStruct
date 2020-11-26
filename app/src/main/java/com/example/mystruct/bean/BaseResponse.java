package com.example.mystruct.bean;

public class BaseResponse<T> {

    int code;

    String msg;

    T data;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
