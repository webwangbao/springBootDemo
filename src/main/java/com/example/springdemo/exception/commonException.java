package com.example.springdemo.exception;


import com.example.springdemo.utildomain.ResponseEnum;

/**
 * 统一异常
 */
public class commonException extends RuntimeException {
    private Integer code;

    private ResponseEnum responseEnum;

    public commonException(){

    }

    public commonException(ResponseEnum responseEnum){
        super(responseEnum.getMessage());
        this.code = responseEnum.getCode();
    }
    public commonException(Integer code,String message){
        super(message);
        this.code = code;

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
