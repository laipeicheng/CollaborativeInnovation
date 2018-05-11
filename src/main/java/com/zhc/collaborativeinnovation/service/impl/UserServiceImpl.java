package com.zhc.collaborativeinnovation.service.impl;

import com.zhc.collaborativeinnovation.vo.User;
import com.zhc.collaborativeinnovation.service.UserService;
import com.zhc.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Override
    public User get(Serializable id) {
        return super.get(User.class, id);
    }

}
