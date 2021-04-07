package com.shillu.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shillu.server.pojo.File;
import com.shillu.server.pojo.RespBean;
import org.springframework.security.core.Authentication;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shillu
 * @since 2021-03-16
 */
public interface IFileService extends IService<File> {

    /**
     * 上传文件
     * @param url
     * @return
     */
    RespBean addFileShare(String url,String[] filePath,String name);
}
