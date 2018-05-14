package com.example.springdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.springdemo.domain.User;
import com.example.springdemo.mapper.UserMapper;
import com.example.springdemo.service.UerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UerService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        logger.info("通过ID查询user参数id = {}", id);
        User user = userMapper.getUserById(id);
        logger.info("调用usermapper产生结果user = {}", JSON.toJSONString(user));
        return user;
    }
}
