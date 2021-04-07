package com.shillu.server.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shillu.server.pojo.Admin;
import com.shillu.server.pojo.RespBean;
import com.shillu.server.service.IAdminService;
import com.shillu.server.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shillu
 * @since 2021-02-21
 */
@RestController
@RequestMapping("/system/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;
    @Autowired
    private IRoleService roleService;

    /**
     * 获取所有操作员
     * @param keywords
     * @return
     */
    @ApiOperation("获取所有操作员")
    @GetMapping("/")
    public List<Admin> getAllAdmins(String keywords){
        return adminService.getAllAdmins(keywords);
    }

    /**
     * 更新操作员
     * @param admin
     * @return
     */
    @ApiOperation("更新操作员")
    @PutMapping("/")
    public RespBean updateAdmin(@RequestBody Admin admin){
        if(adminService.updateById(admin)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    /**
     * 删除操作员
     * @param id
     * @return
     */
    @ApiOperation("删除操作员")
    @DeleteMapping("/{id}")
    public RespBean deleteAdmin(@PathVariable Integer id){
        if(adminService.removeById(id)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    /* @ApiOperation("修改操作员状态")
    @PutMapping("/")
    public RespBean updateAdminStatus(Integer id,Boolean enabled){
        Admin admin = new Admin();
        admin.setId(id);
        admin.setEnabled(enabled);
        if(adminService.updateById(admin)){
            return RespBean.success("修改成功！");
        }
        return RespBean.error("修改错误！");
    }



    @ApiOperation("获取所有角色")
    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return roleService.list();
    }

    @ApiOperation("更新操作员角色")
    @PutMapping("/role")
    public RespBean updateAdminRole(Integer id, Integer[] rids){
        return adminService.updateAdminRole(id,rids);
    }
*/
}
