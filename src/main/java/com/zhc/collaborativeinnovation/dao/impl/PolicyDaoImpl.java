package com.zhc.collaborativeinnovation.dao.impl;

import com.zhc.collaborativeinnovation.dao.PolicyDao;
import com.zhc.collaborativeinnovation.vo.Policy;
import com.zhc.core.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("policyDao")
public class PolicyDaoImpl extends BaseDaoImpl<Policy> implements PolicyDao {
    @Override
    public List<Policy> listTop5() {
        return listTop(Policy.class, 5);
    }

    @Override
    public List<Policy> findByPage(int page, int pageSize) {
        String hql = "from Policy order by publishtime desc";
        return findByPage(hql, page-1, pageSize);
    }
}
