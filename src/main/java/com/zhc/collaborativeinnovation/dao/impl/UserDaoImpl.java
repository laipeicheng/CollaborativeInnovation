package com.zhc.collaborativeinnovation.dao.impl;

import com.zhc.collaborativeinnovation.dao.UserDao;
import com.zhc.collaborativeinnovation.vo.User;
import com.zhc.core.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User get(Serializable id) {
        return get(User.class, id);
    }

    @Override
    public List<User> findByPage(int page, Integer roleid, String keyword) {
        String hql = "from User where role.roleid!=0";
        if (null != roleid) {
            hql += " and role.roleid=" + roleid;
        }
        if (null != keyword) {
            hql += " and (username like '%" + keyword + "%' or realname like '%" + keyword + "%' or phone like '%" + keyword + "%')";
        }
        return findByPage(hql, page - 1, 8);
    }

    @Override
    public int getPages(int pageSize, Integer roleid, String keyword) {
        String hql = "select count(*) from User where role.roleid!=0";
        if (null != roleid) {
            hql += " and role.roleid=" + roleid;
        }
        if (null != keyword) {
            hql += " and (username like '%" + keyword + "%' or realname like '%" + keyword + "%' or phone like '%" + keyword + "%')";
        }
        Iterator iterator = hibernateTemplate.find(hql).listIterator();
        long count = 0;
        if (iterator.hasNext()) {
            count = (Long) iterator.next();
        }
        int pages = (int) count / pageSize;
        if (count % pageSize != 0) {
            pages++;
        }
        return pages;
    }

    @Override
    public boolean isExist(String username, String phone) {
        String hql = "from User where username=? and phone=?";
        List list = hibernateTemplate.find(hql, username, phone);
        if (list != null && !list.isEmpty()){
            return true;
        }
        return false;
    }

}
