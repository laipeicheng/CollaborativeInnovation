package com.zhc.collaborativeinnovation.dao;

import com.zhc.collaborativeinnovation.vo.News;
import com.zhc.core.dao.BaseDao;

import java.util.List;

public interface NewsDao extends BaseDao<News> {

    List<News> listTop5();

    List<News> findByPage(int page, int pageSize);
}
