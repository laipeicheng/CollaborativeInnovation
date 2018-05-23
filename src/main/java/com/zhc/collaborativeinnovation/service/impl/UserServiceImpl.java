package com.zhc.collaborativeinnovation.service.impl;

import com.zhc.collaborativeinnovation.dao.UserDao;
import com.zhc.collaborativeinnovation.service.UserService;
import com.zhc.collaborativeinnovation.vo.User;
import com.zhc.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    @Override
    public User get(Serializable id) {
        return userDao.get(id);
    }

    @Override
    public List<User> findByPage(int page) {
        return userDao.findByPage(page);
    }

}
