package com.spring.layer.service;


import com.spring.layer.entity.Dept;

import java.util.List;

public interface DeptService {

    public List<Dept> queryDeptList(Dept dept);

    int add(Dept dept);

    Dept queryById(Integer id);

    int deleteById(Integer id);

    int editDept(Dept dept);
}
