package com.example.springdemo.service.impl;

import com.example.springdemo.domain.User;
import com.example.springdemo.mapper.UserMapper;
import com.example.springdemo.service.UerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UerService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }
}
