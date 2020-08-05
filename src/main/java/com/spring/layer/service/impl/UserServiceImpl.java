package com.spring.layer.service.impl;

import com.spring.layer.entity.User;
import com.spring.layer.mapper.UserMapper;
import com.spring.layer.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Override
    public User findUserById(Integer id) {
        logger.info("{}查询走的是数据库",id);
        return userMapper.findUserById(id);
    }

    @Override
    public int edit(User user) {
        return userMapper.edit(user);
    }

    @Override
    public int create(User user) {
        return userMapper.create(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public int batchDelete(List<Integer> ids) {
        return userMapper.batchDelete(ids);
    }

    @Override
    public List<User> query(User user) {
        if(user != null){
            int start = (user.getPage() - 1) * user.getLimit();
            user.setStart(start);
        }
        return userMapper.query(user);
    }

    @Override
    public User queryUser(User user) {
        return userMapper.queryUser(user);
    }

    @Override
    public int count(User user) {
        return userMapper.count(user);
    }

    @Override
    public User findUserByName(String name) {
        return userMapper.findUserByName(name);
    }
}
