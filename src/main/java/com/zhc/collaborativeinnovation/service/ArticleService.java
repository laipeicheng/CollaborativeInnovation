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

    int getPages(int pageSize, Integer articletypeid, String username, String keyword);

    List<Article> listByUsername(String username, int page, Integer articletypeid, String keyword);

    List<Article> list(int curPage, Integer articletypeid, String keyword);

    List<Article> favoriteList(String username, int page);

    int favPages(String username);

    void changeFavoriteCounts(int articleid);
}
