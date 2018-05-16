package com.zhc.collaborativeinnovation.service;

import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.core.service.BaseService;

import java.io.Serializable;
import java.util.List;

public interface ArticleService extends BaseService<Article> {

    List<Article> listSortByPublishtime();

    List<Article> listSortByPageview();

    List<Article> listSortByRecentReply();

    List<Article> listByArticletype(int articletypeid, int page);

    Article get(Serializable id);

    int getPages(Integer articletypeid, String username);

    List<Article> listByUsername(String username, int page);

    List<Article> list(int curPage);

    List<Article> favoriteList(String username, int page);

    int favPages(String username);
}
