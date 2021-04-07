package com.shillu.server.service.impl;

import com.shillu.server.pojo.Position;
import com.shillu.server.mapper.PositionMapper;
import com.shillu.server.service.IPositionService;
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
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements IPositionService {

}
