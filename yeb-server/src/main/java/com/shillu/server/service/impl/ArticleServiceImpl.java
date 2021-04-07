package com.shillu.server.service.impl;

import com.shillu.server.mapper.ArticleMapper;
import com.shillu.server.pojo.Article;
import com.shillu.server.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shillu
 * @since 2021-03-18
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
