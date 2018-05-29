package com.zhc.collaborativeinnovation.dao;

import com.zhc.core.dao.BaseDao;

import java.util.List;

public interface SearchDao extends BaseDao {

    List<String> getConditionList(int page, int pageSize, String keyword);

}
