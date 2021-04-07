package com.shillu.server.controller;

import com.shillu.server.pojo.Admin;
import com.shillu.server.pojo.RespBean;
import com.shillu.server.service.IAdminService;
import com.shillu.server.utils.FastDFSUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author shillu
 * @version 1.0
 * @date 2021/3/10 14:51
 * 个人中心
 */
@RestController
public class AdminInfoController {

    @Autowired
    private IAdminService adminService;

    /**
     * 更新当前用户信息
     * @param admin
     * @param authentication
     * @return
     */
    @ApiOperation(value = "更新当前用户信息")
    @PutMapping("/admin/info")
    public RespBean updateAdmin(@RequestBody Admin admin, Authentication authentication){
        if (adminService.updateById(admin)) {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(admin,null,authentication.getAuthorities()));
            return RespBean.success("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    /**
     * 更新用户密码
     * @param info
     * @return
     */
    @ApiOperation(value = "更新用户密码")
    @PutMapping("/admin/pass")
    public RespBean updateAdminPassword(@RequestBody Map<String,Object> info){
        String oldPass = (String) info.get("oldPass");
        String pass = (String) info.get("pass");
        Integer adminId = (Integer) info.get("adminId");
        return adminService.updateAdminPassword(oldPass,pass,adminId);
    }

    /**
     * 更新用户头像
     * @param file
     * @param id
     * @param authentication
     * @return
     */
    @ApiOperation(value = "更新用户头像")
    @PostMapping("/admin/userface")
    public RespBean updateAdminUserFace(MultipartFile file,Integer id,Authentication authentication){
        String[] filePath = FastDFSUtils.upload(file);
        String url = FastDFSUtils.getTrackerUrl() + filePath[0] + "/" + filePath[1];
        return adminService.updateAdminUserFace(url,id,authentication);
    }
}
