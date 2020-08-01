package com.spring.layer.mapper;

import com.spring.layer.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeptMapper {

    List<Dept> quertDeptList(Dept dept);

    int add(Dept dept);

    Dept queryById(@Param("id") Integer id);

    int editDept(Dept dept);

    int deleteById(@Param("id") Integer id);
}
