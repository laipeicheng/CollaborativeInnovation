package com.zhc.collaborativeinnovation.dao;

import com.zhc.collaborativeinnovation.vo.User;
import com.zhc.core.dao.BaseDao;

import java.io.Serializable;
import java.util.List;

public interface UserDao extends BaseDao<User> {

    User get(Serializable id);

    List<User> findByPage(int page);
}
