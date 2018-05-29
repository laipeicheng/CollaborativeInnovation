package com.zhc.collaborativeinnovation.dao;

import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.core.dao.BaseDao;

import java.util.List;

public interface ArticleDao extends BaseDao<Article> {

    List<Article> orderBy(String oderBy);

    List<Article> orderByRecentReply();

    List<Article> listByArticletype(int articletypeid, int page);

    List<Article> listByUsername(String username, int page, Integer articletypeid, String keyword);

    List<Article> list(int curPage, int pageSize, Integer articletypeid, String keyword);

    int getPages(int pageSize, Integer articletypeid, String username, String keyword);

    int favPages(String username);

    List<Article> favoriteList(String username, int page);

}
