package com.shillu.server.mapper;

import com.shillu.server.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shillu.server.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shillu
 * @since 2021-02-21
 */
public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 获取所有操作员
     * @param keywords
     * @return
     */
    List<Admin> getAllAdmins(@Param("id") Integer id, @Param("keywords") String keywords);
}
