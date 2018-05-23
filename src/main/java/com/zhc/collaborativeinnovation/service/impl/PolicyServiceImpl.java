package com.zhc.collaborativeinnovation.service.impl;

import com.zhc.collaborativeinnovation.dao.PolicyDao;
import com.zhc.collaborativeinnovation.dao.impl.PolicyDaoImpl;
import com.zhc.collaborativeinnovation.service.PolicyService;
import com.zhc.collaborativeinnovation.vo.Policy;
import com.zhc.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("policyService")
public class PolicyServiceImpl extends BaseServiceImpl<Policy> implements PolicyService {

    @Autowired
    @Qualifier("policyDao")
    private PolicyDao policyDao;

    @Override
    public List<Policy> listTop5() {
        return policyDao.listTop5();
    }

    @Override
    public List<Policy> findByPage(int page, int pageSize) {
        return policyDao.findByPage(page, pageSize);
    }
}
