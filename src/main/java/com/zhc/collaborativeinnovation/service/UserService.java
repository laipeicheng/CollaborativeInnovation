package com.zhc.collaborativeinnovation.service;

import com.zhc.collaborativeinnovation.vo.User;
import com.zhc.core.service.BaseService;

import java.io.Serializable;

public interface UserService extends BaseService<User> {
    User get(Serializable id);
}
