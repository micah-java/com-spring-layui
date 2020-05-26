package com.spring.layer.service;


import com.spring.layer.entity.User;

import java.util.List;

public interface UserService {

    public User findUserById(Integer id);
    public User updateUser(User user);
    public int create(User user);
    public int deleteUserById(Integer id);
    public List<User> query(User user);
    public int count(User user);
}
