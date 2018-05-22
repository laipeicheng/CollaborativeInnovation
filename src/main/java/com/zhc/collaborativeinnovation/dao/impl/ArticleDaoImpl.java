package com.zhc.collaborativeinnovation.dao.impl;

import com.zhc.collaborativeinnovation.dao.ArticleDao;
import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.core.dao.impl.BaseDaoImpl;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("articleDao")
public class ArticleDaoImpl extends BaseDaoImpl<Article> implements ArticleDao {
    @Override
    public List<Article> orderBy(String oderBy) {
        String hql = "from Article order by " + oderBy + " desc";
        return findByPage(hql, 0, 6);
    }

    @Override
    public List<Article> orderByRecentReply() {
        List<Integer> articleidList = (List<Integer>) hibernateTemplate.execute(new HibernateCallback<List<Integer>>() {
            @Override
            public List<Integer> doInHibernate(Session session) throws HibernateException {
                String hql = "select reply.article.articleid from Reply reply order by replytime desc";
                Query<Integer> query = session.createQuery(hql);
                query.setFirstResult(0);
                query.setMaxResults(6);
                return query.list();
            }
        });
        List<Article> articleList = new ArrayList<Article>();
        for (int id:articleidList){
            Article article = get(Article.class, id);
            articleList.add(article);
        }
        return articleList;
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
