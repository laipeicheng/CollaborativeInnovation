package com.zhc.collaborativeinnovation.dao.impl;

import com.zhc.collaborativeinnovation.dao.NeedsDao;
import com.zhc.collaborativeinnovation.vo.Needs;
import com.zhc.core.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("needsDao")
public class NeedsDaoImpl extends BaseDaoImpl<Needs> implements NeedsDao {

    @Override
    public int getPages(int pageSize, int id) {
        String hql = "select count(*) from Needs where publisher.id=?";
        long count = (Long) hibernateTemplate.find(hql, id).listIterator().next();
        int pages = (int) count / pageSize;
        if (count % pageSize != 0) {
            pages++;
        }
        return pages;
    }

    @Override
    public List<Needs> findByPage(int curPage, int pageSize, int id) {
        String hql = "from Needs where publisher.id=?";
        return findByPage(hql, curPage, pageSize, id);
    }
}
