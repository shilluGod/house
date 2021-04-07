package com.shillu.server.service.impl;

import com.shillu.server.mapper.FileMapper;
import com.shillu.server.pojo.Admin;
import com.shillu.server.pojo.File;
import com.shillu.server.pojo.RespBean;
import com.shillu.server.service.IFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shillu
 * @since 2021-03-16
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

    @Autowired
    private FileMapper fileMapper;

    /**
     * 上传文件
     * @param url
     * @return
     */
    @Override
    public RespBean addFileShare(String url,String[] filePath,String name) {
        File file = new File();
        file.setFilePath(url);
        file.setFilename(name);
        file.setGroupname(filePath[0]);
        file.setRemotename(filePath[1]);
        file.setEnabled(true);
        int result = fileMapper.insert(file);
        if (1==result){
            return RespBean.success("上传成功!");
        }
        return RespBean.error("上传失败!");
    }
}
