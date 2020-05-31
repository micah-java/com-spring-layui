package com.spring.layer.service;


import com.spring.layer.entity.User;
import com.spring.layer.entity.UserTree;

import java.util.List;

public interface UserService {

    public User findUserById(Integer id);
    public int edit(User user);
    public int create(User user);
    public int deleteUserById(Integer id);
    public int batchDelete(List<Integer> ids);
    public List<UserTree> queryTree();
    public int addTree(UserTree userTree);
    public int delTree(Integer id);
    public List<User> query(User user);
    public int count(User user);
}
