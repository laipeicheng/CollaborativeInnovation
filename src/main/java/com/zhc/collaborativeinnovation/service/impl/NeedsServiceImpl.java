package com.zhc.collaborativeinnovation.service.impl;

import com.zhc.collaborativeinnovation.dao.NeedsDao;
import com.zhc.collaborativeinnovation.service.NeedsService;
import com.zhc.collaborativeinnovation.vo.Needs;
import com.zhc.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("needsService")
public class NeedsServiceImpl extends BaseServiceImpl<Needs> implements NeedsService {

    @Autowired
    @Qualifier("needsDao")
    private NeedsDao needsDao;

    @Override
    public int getPages(int pageSize, int id) {
        return needsDao.getPages(pageSize, id);
    }

    @Override
    public List<Needs> findByPage(int curPage, int pageSize, int id) {
        return needsDao.findByPage(curPage, pageSize, id);
    }

    @Override
    public List<Needs> listTop5() {
        return needsDao.listTop5();
    }

    @Override
    public List<Needs> findByPage(int page, int pageSize) {
        return needsDao.findByPage(page, pageSize);
    }
}
