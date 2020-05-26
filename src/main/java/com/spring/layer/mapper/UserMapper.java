package com.spring.layer.mapper;

import com.spring.layer.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    User findUserById(Integer id);

    int updateUser(User user);

    int create(User user);

    int deleteUserById(Integer id);

    int count(User user);

    List<User> query(User user);

}
