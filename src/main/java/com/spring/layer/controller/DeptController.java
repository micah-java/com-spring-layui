package com.spring.layer.controller;

import com.spring.layer.entity.Dept;
import com.spring.layer.entity.Result;
import com.spring.layer.service.DeptService;
import com.spring.layer.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {

    private static final Logger logger = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    UserService userService;

    @Autowired
    DeptService deptService;

    @RequestMapping
    public String dept() {
        return "page/dept";
    }

    @RequestMapping("/query")
    @ResponseBody
    public Result<List<Dept>> query(Dept dept){
        List<Dept> depts = deptService.queryDeptList(dept);
        Result<List<Dept>> deptResult = new Result<>(0, depts.size(), depts);
        return deptResult;
    }

    @RequestMapping("/add/page")
    public String addDeptPage(@RequestParam("type") Integer type, @RequestParam("parentId") Integer parentId, Model model){
        model.addAttribute("type",type);
        model.addAttribute("parentId",parentId);
        return "page/dept_add";
    }

    @RequestMapping("/add")
    @ResponseBody
    public Result addDept(Dept dept){
        int line = deptService.add(dept);
        return Result.ok();
    }

    @RequestMapping("/query/{id}")
    @ResponseBody
    public Result<Dept> queryById(@PathVariable("id") Integer id){
        Dept dept = deptService.queryById(id);
        Result<Dept> deptResult = new Result<>(0, 1, dept);
        return deptResult;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public Result<Dept> editDept(Dept dept){
        int lines = deptService.editDept(dept);
        Result<Dept> deptResult = new Result<>(0, lines, dept);
        return deptResult;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public Result<Boolean> deleteById(@PathVariable("id") Integer id){
        int line = deptService.deleteById(id);
        Result<Boolean> result = new Result<>(0, 1, true);
        return result;
    }
}
