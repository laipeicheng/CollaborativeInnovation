package com.zhc.collaborativeinnovation.service;

import com.zhc.collaborativeinnovation.entity.Article;
import com.zhc.core.service.BaseService;

import java.io.Serializable;
import java.util.List;

public interface ArticleService extends BaseService<Article>{

    List<Article> listSortByPublishtime();

    List<Article> listSortByPageview();

    List<Article> listSortByFavoritecount();

    List<Article> listSortByRecentReply();

    Article get(Serializable id);
}
