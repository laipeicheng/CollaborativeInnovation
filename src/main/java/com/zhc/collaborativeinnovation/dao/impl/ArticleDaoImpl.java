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
        String sql = "select * from article where articleid in(" +
                "select distinct articleid from reply order by replytime desc) limit 0, 6";
        return queryWithSql(sql);
    }
}
