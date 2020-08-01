package com.spring.layer.service.impl;

import com.spring.layer.entity.Dept;
import com.spring.layer.mapper.DeptMapper;
import com.spring.layer.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    private static Logger logger = LoggerFactory.getLogger(DeptServiceImpl.class);

    @Resource
    private DeptMapper deptMapper;

    @Override
    public List<Dept> queryDeptList(Dept dept) {
        return deptMapper.quertDeptList(dept);
    }

    @Override
    public int add(Dept dept) {
        return deptMapper.add(dept);
    }

    @Override
    public Dept queryById(Integer id) {
        return deptMapper.queryById(id);
    }

    @Override
    public int editDept(Dept dept) {
        return deptMapper.editDept(dept);
    }

    @Override
    public int deleteById(Integer id) {
        return deptMapper.deleteById(id);
    }
}
