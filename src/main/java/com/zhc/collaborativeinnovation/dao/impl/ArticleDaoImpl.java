package com.zhc.collaborativeinnovation.dao.impl;

import com.zhc.collaborativeinnovation.dao.ArticleDao;
import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.core.dao.impl.BaseDaoImpl;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("articleDao")
public class ArticleDaoImpl extends BaseDaoImpl<Article> implements ArticleDao {
    @Override
    public List<Article> orderBy(String oderBy) {
        String hql = "from Article order by "+oderBy+" desc";
        return findByPage(hql, 0, 6);
    }

    @Override
    public List<Article> orderByRecentReply() {
        String hql = "from Article where articleid in(select reply.article.articleid from Reply reply order by replytime desc)";
        return findByPage(hql, 0, 6);
    }

    @Override
    public List<Article> listByArticletype(int articletypeid, int page) {
        String hql = "from Article where articletype.articletypeid=? order by publishtime desc";
        return findByPage(hql, page - 1, 6, articletypeid);
    }

    @Override
    public List<Article> listByUsername(String username, int page) {
        String hql = "from Article where author.username=? order by publishtime desc";
        return findByPage(hql, page - 1, 8, username);
    }

    @Override
    public List<Article> list(int curPage) {
        String hql = "from Article order by publishtime desc";
        return findByPage(hql, curPage - 1, 8);
    }

    @Override
    public int getPages(Integer articletypeid, String username) {
        String hql = "select count(*) from Article ";
        int pageSize = 8;
        if (null != articletypeid) {
            hql += "where articletype.articletypeid=" + articletypeid;
            pageSize = 6;
        }
        if (null != username) {
            hql += "where author.username='" + username + "'";
        }
        long count = (Long) hibernateTemplate.find(hql).listIterator().next();
        int pages = (int) count / pageSize;
        if (count % pageSize != 0) {
            pages++;
        }
        return pages;
    }

    @Override
    public int favPages(String username) {
        String hql = "select count(*) from Favorite where username=?";

        long count = (Long) hibernateTemplate.find(hql, username).listIterator().next();
        int pages = (int) count / 6;
        if (count % 6 != 0) {
            pages++;
        }
        return pages;
    }

    @Override
    public List<Article> favoriteList(String username, int page) {
        String hql = "from Article as article where article.articleid in (select favorite.articleid from Favorite as favorite where favorite.username=?)";
        return findByPage(hql, page - 1, 6, username);
    }
}
