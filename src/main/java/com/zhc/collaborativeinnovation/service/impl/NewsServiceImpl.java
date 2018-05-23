package com.zhc.collaborativeinnovation.service.impl;

import com.zhc.collaborativeinnovation.dao.NewsDao;
import com.zhc.collaborativeinnovation.service.NewsService;
import com.zhc.collaborativeinnovation.vo.News;
import com.zhc.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("newsService")
public class NewsServiceImpl extends BaseServiceImpl<News> implements NewsService {

    @Autowired
    @Qualifier("newsDao")
    private NewsDao newsDao;

    @Override
    public List<News> listTop5() {
        return newsDao.listTop5();
    }

    @Override
    public List<News> findByPage(int page, int pageSize) {
        return newsDao.findByPage(page, pageSize);
    }
}
