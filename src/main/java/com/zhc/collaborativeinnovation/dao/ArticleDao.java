package com.zhc.collaborativeinnovation.dao;

import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.core.dao.BaseDao;

import java.util.List;

public interface ArticleDao extends BaseDao<Article> {

    List<Article> orderByCriterion(String oderBy);

    List<Article> orderByRecentReply();
}
