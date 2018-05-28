package com.zhc.collaborativeinnovation.dao.impl;

import com.zhc.collaborativeinnovation.dao.ArticleDao;
import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.core.dao.impl.BaseDaoImpl;
import org.hibernate.HibernateException;
import org.hibernate.Session;
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
                String hql = "select distinct reply.article.articleid from Reply reply order by replytime desc";
                Query<Integer> query = session.createQuery(hql);
                query.setFirstResult(0);
                query.setMaxResults(6);
                return query.list();
            }
        });
        List<Article> articleList = new ArrayList<Article>();
        for (int id : articleidList) {
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
    public List<Article> listByUsername(String username, int page, Integer articletypeid, String keyword) {
        String hql = "from Article where author.username=?";
        if (null != articletypeid) {
            hql += " and articletype.articletypeid=" + articletypeid;
        }
        if (null != keyword){
            hql += " and (title like '%"+keyword+"%' or author.realname like '%"+keyword+"%')";
        }
        hql += " order by publishtime desc";
        return findByPage(hql, page - 1, 8, username);
    }

    @Override
    public List<Article> list(int curPage, Integer articletypeid, String keyword) {
        String hql = "from Article where 1=1";
        if (null != articletypeid) {
            hql += " and articletype.articletypeid=" + articletypeid;
        }
        if (null != keyword){
            hql += " and (title like '%"+keyword+"%' or author.realname like '%"+keyword+"%')";
        }
        hql += " order by publishtime desc";
        return findByPage(hql, curPage - 1, 8);
    }

    @Override
    public int getPages(int pageSize, Integer articletypeid, String username, String keyword) {
        String hql = "select count(*) from Article where 1=1";
        if (null != articletypeid) {
            hql += " and articletype.articletypeid=" + articletypeid;
        }
        if (null != username) {
            hql += " and author.username='" + username + "'";
        }
        if (null != keyword){
            hql += " and (title like '%"+keyword+"%' or author.realname like '%"+keyword+"%')";
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
