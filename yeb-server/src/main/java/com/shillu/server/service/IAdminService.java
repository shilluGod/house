package com.shillu.server.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.shillu.server.pojo.Admin;
import com.shillu.server.pojo.Menu;
import com.shillu.server.pojo.RespBean;
import com.shillu.server.pojo.Role;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shillu
 * @since 2021-02-21
 */
public interface IAdminService extends IService<Admin> {
    /**
     * 登录之后返回token
     *
     * @param username username
     * @param password password
     * @param code code
     * @param request request
     * @return token
     */
    RespBean login(String username, String password, String code, HttpServletRequest request);

    /**
     * 根据用户名获取用户
     * @param username username
     * @return admin
     */
    Admin getAdminByUserName(String username);


    /**
     * 根据用户id查询角色列表
     * @param adminId
     * @return
     */
    List<Role> getRoles(Integer adminId);

    /**
     * 更新用户密码
     * @param oldPass
     * @param pass
     * @param adminId
     * @return
     */
    RespBean updateAdminPassword(String oldPass, String pass, Integer adminId);

    /**
     * 获取所有操作员
     * @param keywords
     * @return
     */
    List<Admin> getAllAdmins(String keywords);

    /**
     * 更新用户头像
     * @param url
     * @param id
     * @param authentication
     * @return
     */
    RespBean updateAdminUserFace(String url, Integer id, Authentication authentication);
}
