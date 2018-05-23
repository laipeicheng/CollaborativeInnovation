package com.zhc.collaborativeinnovation.service;

import com.zhc.collaborativeinnovation.vo.News;
import com.zhc.core.service.BaseService;

import java.util.List;

public interface NewsService extends BaseService<News> {

    List<News> listTop5();

    List<News> findByPage(int page, int pageSize);
}
