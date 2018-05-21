package com.zhc.collaborativeinnovation.service.impl;

import com.zhc.collaborativeinnovation.dao.EnterpriseDao;
import com.zhc.collaborativeinnovation.service.EnterpriseService;
import com.zhc.collaborativeinnovation.vo.Enterprise;
import com.zhc.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("enterpriseService")
public class EnterpriseServiceImpl extends BaseServiceImpl<Enterprise> implements EnterpriseService {

    @Autowired
    @Qualifier("enterpriseDao")
    private EnterpriseDao enterpriseDao;

    @Override
    public Enterprise getByUsername(String username) {
        return enterpriseDao.getByUsername(username);
    }

    @Override
    public List<Enterprise> listByStatus(int curPage, int status) {
        return enterpriseDao.listByStatus(curPage, status);
    }

    @Override
    public int getPagesByStatus(int status) {
        return enterpriseDao.getPagesByStatus(status);
    }
}
