package com.shillu.server.controller;


import com.shillu.server.pojo.Menu;
import com.shillu.server.service.IAdminService;
import com.shillu.server.service.IMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shillu
 * @since 2021-02-28
 */
@RestController
@RequestMapping("/system/config")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @ApiOperation(value = "通过用户id查询菜单列表")
    @GetMapping("/menu")
    public List<Menu> getMenusByAdminId(){

        return menuService.getMenusByAdminId();
    }
}
