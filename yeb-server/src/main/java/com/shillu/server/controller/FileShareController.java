package com.shillu.server.controller;

import com.shillu.server.pojo.File;
import com.shillu.server.pojo.RespBean;
import com.shillu.server.service.IFileService;
import com.shillu.server.utils.FastDFSUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @author shillu
 * @version 1.0
 * @date 2021/3/16 16:11
 * 资源分享
 */
@RestController
@RequestMapping("/system/file")
public class FileShareController {

    @Autowired
    private IFileService fileService;

    /**
     * 获取所有资源列表
     *
     * @return
     */
    @ApiOperation(value = "获取所有资源列表")
    @GetMapping("/")
    public List<File> getAllFile() {
        return fileService.list();
    }

    /**
     * 文件上传
     * 文件名怎么保存下来还未解决
     * 文件大小受限制未解决
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "文件上传")
    @PostMapping("/upload")
    public RespBean addFileShare(MultipartFile file) {
        String[] filePath = FastDFSUtils.upload(file);
        String url = FastDFSUtils.getTrackerUrl() + filePath[0] + "/" + filePath[1];
        String name = file.getOriginalFilename();
        return fileService.addFileShare(url, filePath, name);
    }

    @ApiOperation(value = "文件下载")
    @PostMapping("/download/{id}")
    public RespBean downFileShare(@PathVariable Integer id) {
        String groupName = fileService.getById(id).getGroupname();
        String remoteFileName = fileService.getById(id).getRemotename();
        InputStream inputStream = FastDFSUtils.downFile(groupName, remoteFileName);
        if (null != inputStream) {
            return RespBean.success("下载成功!");
        }
        return RespBean.error("下载失败!");
    }

    /**
     * 删除文件
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除文件")
    @DeleteMapping("/{id}")
    public RespBean deleteFileShare(@PathVariable Integer id ,String groupName, String remoteFileName) {
        groupName = fileService.getById(id).getGroupname();
        remoteFileName = fileService.getById(id).getRemotename();
        FastDFSUtils.deleteFile(groupName, remoteFileName);
        if (fileService.removeById(id)) {
            return RespBean.success("删除成功!");
        }
        return RespBean.error("删除失败");
    }


}
