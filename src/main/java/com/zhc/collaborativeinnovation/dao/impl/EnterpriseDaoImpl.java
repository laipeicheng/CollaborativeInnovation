package com.zhc.collaborativeinnovation.dao.impl;

import com.zhc.collaborativeinnovation.dao.EnterpriseDao;
import com.zhc.collaborativeinnovation.vo.Enterprise;
import com.zhc.core.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("enterpriseDao")
public class EnterpriseDaoImpl extends BaseDaoImpl<Enterprise> implements EnterpriseDao {

    @Override
    public Enterprise getByUsername(String username) {
        final String hql = "from Enterprise where corporation.username = ?";
        List list = hibernateTemplate.find(hql, username);
        if (list == null || list.isEmpty()) {
            return null;
        } else {
            return (Enterprise) list.get(0);
        }
    }

    @Override
    public List<Enterprise> listByStatus(int curPage, int status) {
        String hql = "from Enterprise where status=?";
        return findByPage(hql, curPage - 1, 8, status);
    }

    @Override
    public int getPagesByStatus(int status) {
        String hql = "select count(*) from Enterprise where status=?";
        long count = (Long) hibernateTemplate.find(hql, status).listIterator().next();
        int pages = (int) count / 8;
        if (count % 8 != 0) {
            pages++;
        }
        return pages;
    }
}
