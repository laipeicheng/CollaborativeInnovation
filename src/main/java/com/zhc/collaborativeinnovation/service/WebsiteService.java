package com.zhc.collaborativeinnovation.service;

import com.zhc.collaborativeinnovation.vo.Website;
import com.zhc.core.service.BaseService;

import java.util.List;

public interface WebsiteService extends BaseService<Website> {

    List<Website> findByPage(int currPage, int pageSize, String username);

    int getPages(int pageSize, String username);
}
