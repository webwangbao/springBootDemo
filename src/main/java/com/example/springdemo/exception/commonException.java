package com.example.springdemo.exception;

import com.example.springdemo.utildomain.ResponseEnum;

/**
 * 统一异常
 */
public class commonException extends RuntimeException{
    private Integer code;
    private ResponseEnum responseEnum;

    public commonException(ResponseEnum responseEnum){
        super(responseEnum.getMessage());
        this.code = responseEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ResponseEnum getResponseEnum() {
        return responseEnum;
    }

    public void setResponseEnum(ResponseEnum responseEnum) {
        this.responseEnum = responseEnum;
    }
}
