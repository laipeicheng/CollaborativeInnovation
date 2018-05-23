package com.zhc.collaborativeinnovation.dao;

import com.zhc.collaborativeinnovation.vo.Enterprise;
import com.zhc.core.dao.BaseDao;

import java.util.List;

public interface EnterpriseDao extends BaseDao<Enterprise> {

    Enterprise getByUsername(String username);

    List<Enterprise> listByStatus(int curPage, int status);

    int getPagesByStatus(int status);
}
