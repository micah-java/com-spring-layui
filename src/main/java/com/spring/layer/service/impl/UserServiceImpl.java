package com.spring.layer.service.impl;

import com.spring.layer.entity.User;
import com.spring.layer.entity.UserTree;
import com.spring.layer.mapper.UserMapper;
import com.spring.layer.mapper.UserTreeMapper;
import com.spring.layer.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserTreeMapper userTreeMapper;

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
    public int count(User user) {
        return userMapper.count(user);
    }

    @Override
    public List<UserTree> queryTree() {
        List<UserTree> userTree = userTreeMapper.queryTree();
        List<UserTree> userRootTree = userTree.stream().filter(e -> e.getPid() == null).collect(Collectors.toList());
        for(UserTree r:userRootTree){
            List<UserTree> children = bilidChildren(r.getId(), userTree);
            r.setChildren(children);
        }
        return userRootTree;
    }

    //递归构建子节点
    private List<UserTree> bilidChildren(Integer id,List<UserTree> userTree){
        List<UserTree> userChildren = new ArrayList<>();
        for(UserTree u:userTree){
            if(id == u.getPid()){
                userChildren.add(u);
            }
        }
        for(UserTree c:userChildren){
            c.setChildren(bilidChildren(c.getId(),userTree));
        }
        return userChildren;
    }

    @Override
    public int addTree(UserTree userTree) {
        return userTreeMapper.addTree(userTree);
    }

    @Override
    public int delTree(Integer id) {
        return userTreeMapper.delTree(id);
    }
}
