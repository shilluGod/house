package com.shillu.server.service.impl;

import com.shillu.server.pojo.Role;
import com.shillu.server.mapper.RoleMapper;
import com.shillu.server.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shillu
 * @since 2021-03-01
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
