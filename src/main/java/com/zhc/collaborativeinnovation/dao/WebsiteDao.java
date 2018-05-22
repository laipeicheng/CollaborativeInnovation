package com.zhc.collaborativeinnovation.dao;

import com.zhc.collaborativeinnovation.vo.Website;
import com.zhc.core.dao.BaseDao;

import java.util.List;

public interface WebsiteDao extends BaseDao<Website> {

    List<Website> findByPage(int currPage, int pageSize, String username);

    int getPages(int pageSize, String username);
}
