package com.zhc.collaborativeinnovation.service.impl;

import com.zhc.collaborativeinnovation.entity.Article;
import com.zhc.collaborativeinnovation.service.ArticleService;
import com.zhc.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service("articleService")
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService{

    @Override
    public List<Article> listSortByPublishtime() {
        System.out.println("---------------listSortByPublishtime-----------------");
        return null;
    }

    @Override
    public List<Article> listSortByPageview() {
        System.out.println("-----------------listSortByPageview------------------");
        return null;
    }

    @Override
    public List<Article> listSortByFavoritecount() {
        System.out.println("----------------listSortByFavoritecount--------------");
        return null;
    }

    @Override
    public List<Article> listSortByRecentReply() {
        System.out.println("----------------listSortByRecentReply----------------");
        return null;
    }

    @Override
    public Article get(Serializable id) {
        return this.get(Article.class,id);
    }

}
