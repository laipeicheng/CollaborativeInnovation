package com.zhc.collaborativeinnovation.service;

import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.core.service.BaseService;

import java.io.Serializable;
import java.util.List;

public interface ArticleService extends BaseService<Article>{

    List<Article> listSortByPublishtime();

    List<Article> listSortByPageview();

    List<Article> listSortByFavoritecount();

    List<Article> listSortByRecentReply();

    List<Article> listByArticletype(int articletypeid, int page);

    Article get(Serializable id);
}
