package com.zhc.collaborativeinnovation.dao.impl;

import com.zhc.collaborativeinnovation.dao.ArticleDao;
import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.core.dao.impl.BaseDaoImpl;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("articleDao")
public class ArticleDaoImpl extends BaseDaoImpl<Article> implements ArticleDao {
    @Override
    public List<Article> orderByCriterion(String oderBy) {
        DetachedCriteria criterion = DetachedCriteria.forClass(Article.class);
        criterion.addOrder(Order.desc(oderBy));
        return (List<Article>) hibernateTemplate.findByCriteria(criterion);
    }

    @Override
    public List<Article> orderByRecentReply() {
        String hql = "from Article where articleid in(select reply.article.articleid from Reply reply order by replytime desc)";
        return findByPage(hql, 0, 6);
    }

    @Override
    public List<Article> listByArticletype(int articletypeid, int page) {
        String hql = "from Article where articletype.articletypeid=?";
        return findByPage(hql, page, 6, articletypeid);
    }
}
