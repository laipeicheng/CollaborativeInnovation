package com.zhc.collaborativeinnovation.dao.impl;

import com.zhc.collaborativeinnovation.dao.UserDao;
import com.zhc.collaborativeinnovation.vo.User;
import com.zhc.core.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User get(Serializable id) {
        return get(User.class, id);
    }

    @Override
    public List<User> findByPage(int page) {
        String hql = "from User";
        return findByPage(hql, page - 1, 8);
    }

}
