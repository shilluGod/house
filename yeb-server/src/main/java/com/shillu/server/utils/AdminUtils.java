package com.shillu.server.utils;

import com.shillu.server.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author shillu
 * @version 1.0
 * @date 2021/3/10 17:37
 *
 * 操作员工具类
 */
public class AdminUtils {

    /**
     * 获取当前登录操作员
     * @return
     */
    public static Admin getCurrentAdmin(){
        return (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
