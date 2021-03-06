package com.example.springdemo.controller;

import com.alibaba.fastjson.JSON;
import com.example.springdemo.domain.User;
import com.example.springdemo.exception.commonException;
import com.example.springdemo.service.UerService;
import com.example.springdemo.utildomain.ResponseEnum;
import com.example.springdemo.utildomain.ResponseStatus;
import com.example.springdemo.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(value = "用户操作")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UerService uerService;

    @ApiOperation(value = "根据id查询用户",notes = "根据id查询用户")
    @ApiParam(value = "id",name = "用户id")
    @GetMapping("/getUser/{id}")
    public ResponseStatus getUserById(@PathVariable("id") Integer id) {
        logger.info("getUserById方法接受前端参数ID = {}", id);
        User user = uerService.getUserById(id);
        logger.info("调用userservice的getUserById方法结果是user = {}", JSON.toJSONString(user));
        if (null == user) {
            throw new commonException(ResponseEnum.NOT_FIND_USER_BY_ID.getCode(),ResponseEnum.NOT_FIND_USER_BY_ID.getMessage());
        }
        return ResultUtils.sucess(user);
    }
}
