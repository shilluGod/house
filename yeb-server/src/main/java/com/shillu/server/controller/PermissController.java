package com.shillu.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shillu.server.pojo.Menu;
import com.shillu.server.pojo.MenuRole;
import com.shillu.server.pojo.RespBean;
import com.shillu.server.pojo.Role;
import com.shillu.server.service.IMenuRoleService;
import com.shillu.server.service.IMenuService;
import com.shillu.server.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shillu
 * @version 1.0
 * @date 2021/3/10 14:00
 *
 * 权限组
 */
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IMenuService menuService;

    @Autowired
    private IMenuRoleService menuRoleService;

    /**
     * 获取所有角色
     * @return
     */
    @ApiOperation(value = "获取所有角色")
    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.list();
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @ApiOperation(value = "添加角色")
    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role){
        if (!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_" + role.getName());
        }
        if (roleService.save(role)){
            return RespBean.success("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    /**
     * 删除角色
     * @param rid
     * @return
     */
    @ApiOperation(value = "删除角色")
    @DeleteMapping("/role/{rid}")
    public RespBean deleteRole(@PathVariable Integer rid){
        if (roleService.removeById(rid)){
            return RespBean.success("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    /**
     * 查询所有菜单
     * @return
     */
    @ApiOperation(value = "查询所有菜单")
    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }

    /**
     * 根据角色id查询菜单id
     * @param rid
     * @return
     */
    @ApiOperation(value = "根据角色id查询菜单id")
    @GetMapping("/mid/{rid}")
    public List<Integer> getMidByRid(@PathVariable Integer rid){
        return menuRoleService.list(new QueryWrapper<MenuRole>().eq("rid",rid)).stream().map(MenuRole::getMid).collect(Collectors.toList());
    }

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    @ApiOperation(value = "更新角色菜单")
    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid,Integer[] mids){
        return menuRoleService.updateMenuRole(rid,mids);
    }
}
