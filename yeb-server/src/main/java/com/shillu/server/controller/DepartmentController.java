package com.shillu.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shillu.server.pojo.Department;
import com.shillu.server.service.IDepartmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shillu
 * @since 2021-03-01
 *
 * 有bug但是解决不了，跳过了这部分
 */
@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    /**
     * 获取所有部门
     * @return
     */
    @ApiOperation("获取所有部门")
    @GetMapping("/")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

/*    @ApiOperation("添加部门")
    @PostMapping("/")
    public RespBean addDepartment(@RequestBody Department dept){
        dept.setCreateDate(new Date());
        if(departmentService.save(dept)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation("修改部门")
    @PutMapping("/")
    public RespBean editDepartment(@RequestBody Department department){
        if(departmentService.updateById(department)){
            return RespBean.success("修改成功！",department);
        }
        return RespBean.error("修改失败！");
    }

    @ApiOperation("删除部门")
    @DeleteMapping("/{id}")
    public RespBean DeleteDepartment(@PathVariable("id") Integer id){
        //判断该部门下是否有子部门
        if(0 < departmentService.findContainChildren(id)){
            return RespBean.error("该部门下已有子部门，请先删除子部门！");
        }
        //根据部门id查询该部门下是否有员工
        Employee emp = employeeService.getOne(new QueryWrapper<Employee>().eq("department_id", id));
        if(!ObjectUtils.isEmpty(emp)){
            return RespBean.error("该部门下已有员工，请先删除员工！");
        }
        return departmentService.removeById(id);
    }

    @ApiOperation("修改该部门的父部门")
    @PutMapping("/editParentId/")
    public RespBean editParentId(Integer id,Integer parentId){
        if(departmentService.editParentId(id,parentId)){
            return RespBean.success("修改成功!");
        }
        return RespBean.error("修改失败!");
    }*/
}
