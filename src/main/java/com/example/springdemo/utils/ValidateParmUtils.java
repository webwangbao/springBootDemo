package com.example.springdemo.utils;

import com.example.springdemo.exception.commonException;
import com.example.springdemo.utildomain.ResponseEnum;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * 前端参数校验类
 */
public class ValidateParmUtils {

    public static void validateParm(BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String errorMessage = getMessage(bindingResult);
            if(!StringUtils.isEmpty(errorMessage)){
                ResponseEnum.VALIDATE_PARM_ERROR.setMessage("前端校验参数不合法"+errorMessage);
            }
            throw new commonException(ResponseEnum.VALIDATE_PARM_ERROR);
        }
    }

    public static String getMessage(BindingResult bindingResult){
        StringBuilder sb = new StringBuilder();
        for(ObjectError message : bindingResult.getAllErrors()){
            sb.append(message).append(",");
        }
        return sb.toString();
    }
}
