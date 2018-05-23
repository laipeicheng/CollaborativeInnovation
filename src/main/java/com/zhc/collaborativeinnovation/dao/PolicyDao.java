package com.zhc.collaborativeinnovation.dao;

import com.zhc.collaborativeinnovation.vo.Policy;
import com.zhc.core.dao.BaseDao;

import java.util.List;

public interface PolicyDao extends BaseDao<Policy> {

    List<Policy> listTop5();

    List<Policy> findByPage(int page, int pageSize);
}
