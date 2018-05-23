package com.zhc.collaborativeinnovation.dao;

import com.zhc.collaborativeinnovation.vo.Needs;
import com.zhc.core.dao.BaseDao;

import java.util.List;

public interface NeedsDao extends BaseDao<Needs> {

    int getPages(int pageSize, int id);

    List<Needs> findByPage(int curPage, int pageSize, int id);

    List<Needs> listTop5();

    List<Needs> findByPage(int page, int pageSize);
}
