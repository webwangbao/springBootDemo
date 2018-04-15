package com.example.springdemo.handleException;

import com.example.springdemo.exception.commonException;
import com.example.springdemo.utildomain.ResponseStatus;
import com.example.springdemo.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class HandlerException {
    private static final Logger  logger = LoggerFactory.getLogger(HandlerException.class);

    @ExceptionHandler(value = commonException.class)
    @ResponseBody
    public ResponseStatus handleCommectionException(HttpServletResponse response,commonException e){
        logger.error("错误信息是 e = {}",e.toString());
        response.setStatus(405);
        return ResultUtils.error(e.getResponseEnum());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseStatus handleException(HttpServletResponse response,Exception e){
        logger.error("错误信息e = {}",e.toString());
        response.setStatus(506);
        return ResultUtils.error();

    }
}
