package com.example.springdemo.mapper;

import com.example.springdemo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    /**
     * 通过id查询用户
     *
     * @param id
     * @return
     */
    User getUserById(@Param("id") Integer id);
}
