package com.example.springdemo.controller;

import com.example.springdemo.domain.User;
import com.example.springdemo.exception.commonException;
import com.example.springdemo.service.UerService;
import com.example.springdemo.utildomain.ResponseEnum;
import com.example.springdemo.utildomain.ResponseStatus;
import com.example.springdemo.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UerService uerService;

    @GetMapping("/getUser/{id}")
    public ResponseStatus getUserById(@PathVariable("id") Integer id){
        User user = uerService.getUserById(id);
        if(null == user){
            throw new commonException(ResponseEnum.NOT_FIND_USER_BY_ID);
        }
        return ResultUtils.sucess(user);
    }
}
