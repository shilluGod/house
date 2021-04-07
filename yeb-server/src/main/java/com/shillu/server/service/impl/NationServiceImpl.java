package com.shillu.server.service.impl;

import com.shillu.server.pojo.Nation;
import com.shillu.server.mapper.NationMapper;
import com.shillu.server.service.INationService;
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
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

}
