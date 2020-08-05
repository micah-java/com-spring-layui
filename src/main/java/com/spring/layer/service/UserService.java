package com.spring.layer.service;

import com.spring.layer.entity.User;

import java.util.List;

public interface UserService {

    public User findUserById(Integer id);
    public User findUserByName(String name);
    public int edit(User user);
    public int create(User user);
    public int deleteUserById(Integer id);
    public int batchDelete(List<Integer> ids);
    public List<User> query(User user);
    public User queryUser(User user);
    public int count(User user);
}
