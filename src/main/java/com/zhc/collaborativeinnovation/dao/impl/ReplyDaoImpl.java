package com.zhc.collaborativeinnovation.dao.impl;

import com.zhc.collaborativeinnovation.dao.ReplyDao;
import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.collaborativeinnovation.vo.Reply;
import com.zhc.core.dao.impl.BaseDaoImpl;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("replyDao")
public class ReplyDaoImpl extends BaseDaoImpl<Reply> implements ReplyDao {

    @Override
    public List<Reply> listByPageInUser(int articleid, int curPage) {
        String hql = "from Reply where article.articleid=? order by replytime desc";
        return findByPage(hql, curPage-1, 6, articleid);
    }
}
