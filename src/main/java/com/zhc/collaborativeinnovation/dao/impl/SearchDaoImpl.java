package com.zhc.collaborativeinnovation.dao.impl;

import com.zhc.collaborativeinnovation.dao.SearchDao;
import com.zhc.core.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("searchDao")
public class SearchDaoImpl extends BaseDaoImpl implements SearchDao {

    @Override
    public List<String> getConditionList(int page, int pageSize, String keyword) {

        String hql = "from Article where title like ? or summary like ?";
        List<String> conditionList = new ArrayList<String>();
        List list = findByPage(hql, page-1, pageSize, keyword, keyword);
        if (list != null && !list.isEmpty()) {
            conditionList.add("article");
        }
        hql = "from News where title like ? or summary like ?";
        list = findByPage(hql, page-1, pageSize, keyword, keyword);
        if (list != null && !list.isEmpty()) {
            conditionList.add("news");
        }
        hql = "from Needs where title like ?";
        list = findByPage(hql, page-1, pageSize, keyword);
        if (list != null && !list.isEmpty()) {
            conditionList.add("needs");
        }
        hql = "from Policy where title like ?";
        list = findByPage(hql, page-1, pageSize, keyword);
        if (list != null && !list.isEmpty()) {
            conditionList.add("policy");
        }
        return conditionList;
    }
}
