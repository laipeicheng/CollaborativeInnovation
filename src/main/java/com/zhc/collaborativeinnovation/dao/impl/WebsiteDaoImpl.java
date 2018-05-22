package com.zhc.collaborativeinnovation.dao.impl;

import com.zhc.collaborativeinnovation.dao.WebsiteDao;
import com.zhc.collaborativeinnovation.vo.Website;
import com.zhc.core.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("websiteDao")
public class WebsiteDaoImpl extends BaseDaoImpl<Website> implements WebsiteDao {

    @Override
    public List<Website> findByPage(int currPage, int pageSize, String username) {
        String hql = "from Website where user.username=?";
        return findByPage(hql, currPage - 1, pageSize, username);
    }

    @Override
    public int getPages(int pageSize, String username) {
        String hql = "select count(*) from Website where user.username=?";
        long count = (Long) hibernateTemplate.find(hql, username).listIterator().next();
        int pages = (int) count / pageSize;
        if (count % pageSize != 0) {
            pages++;
        }
        return pages;
    }
}
