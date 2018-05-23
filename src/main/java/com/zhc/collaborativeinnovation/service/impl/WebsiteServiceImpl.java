package com.zhc.collaborativeinnovation.service.impl;

import com.zhc.collaborativeinnovation.dao.WebsiteDao;
import com.zhc.collaborativeinnovation.service.WebsiteService;
import com.zhc.collaborativeinnovation.vo.Website;
import com.zhc.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("websiteService")
public class WebsiteServiceImpl extends BaseServiceImpl<Website> implements WebsiteService {

    @Autowired
    @Qualifier("websiteDao")
    private WebsiteDao websiteDao;

    @Override
    public List<Website> findByPage(int currPage, int pageSize, String username) {
        return websiteDao.findByPage(currPage, pageSize, username);
    }

    @Override
    public int getPages(int pageSize, String username) {
        return websiteDao.getPages(pageSize, username);
    }
}
