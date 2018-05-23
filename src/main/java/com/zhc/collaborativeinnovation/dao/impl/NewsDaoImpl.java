package com.zhc.collaborativeinnovation.dao.impl;

import com.zhc.collaborativeinnovation.dao.NewsDao;
import com.zhc.collaborativeinnovation.vo.News;
import com.zhc.core.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("newsDao")
public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao {
    @Override
    public List<News> listTop5() {
        return listTop(News.class, 5);
    }

    @Override
    public List<News> findByPage(int page, int pageSize) {
        String hql = "from News order by publishtime desc";
        return findByPage(hql, page-1, pageSize);
    }
}
