package com.zhc.collaborativeinnovation.dao;

import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.core.dao.BaseDao;

import java.util.List;

public interface ArticleDao extends BaseDao<Article> {

    List<Article> orderByCriterion(String oderBy);

    List<Article> orderByRecentReply();

    List<Article> listByArticletype(int articletypeid, int page);

    List<Article> listByUsername(String username, int page);

    List<Article> list(int curPage);

    int getPages(Integer articletypeid, String username);

    int favPages(String username);

    List<Article> favoriteList(String username, int page);
}
