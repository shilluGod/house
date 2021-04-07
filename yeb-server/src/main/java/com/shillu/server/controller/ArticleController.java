package com.shillu.server.controller;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shillu.server.mapper.ArticleMapper;
import com.shillu.server.pojo.Article;
import com.shillu.server.pojo.RespBean;
import com.shillu.server.service.IArticleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shillu
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/system/basic/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    /**
     * 获取所有文章列表
     * @return
     */
    @ApiOperation(value = "获取所有文章列表")
    @GetMapping("/")
    public List<Article>getAllArticle(){
        return articleService.list();
    }

    /**
     * 添加文章
     * @param article
     * @return
     */
    @ApiOperation(value = "添加文章")
    @PostMapping("/")
    public RespBean addArticle(@RequestBody Article article) {
        article.setCreateDate(LocalDateTime.now());
        //article.setContent("111");
        article.setEnabled(true);
        //添加是否添加成功
        if (articleService.save(article)){
            return RespBean.success("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    /**
     * 更新文章
     * @param article
     * @return
     */
    @ApiOperation(value = "更新文章")
    @PutMapping("/")
    public RespBean updateArticle(@RequestBody Article article){
        if (articleService.updateById(article)){
            return RespBean.success("修改成功!");
        }
        return RespBean.error("修改失败!");
    }

    @ApiOperation(value = "删除文章")
    @DeleteMapping("/{id}")
    public RespBean deleteArticle(@PathVariable Integer id){
        if (articleService.removeById(id)){
            return RespBean.success("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @ApiOperation(value = "批量文章")
    @DeleteMapping("/")
    public RespBean deleteArticleByIds(Integer[] ids) {
        if (articleService.removeByIds(Arrays.asList(ids))) {   // 一个转换
            return RespBean.success("删除成功!");
        }
        return RespBean.error("删除失败!");
    }


}
