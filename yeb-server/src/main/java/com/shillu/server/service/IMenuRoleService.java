package com.shillu.server.service;

import com.shillu.server.pojo.MenuRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shillu.server.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shillu
 * @since 2021-03-01
 */
public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
