package com.zhc.collaborativeinnovation.service;

import com.zhc.collaborativeinnovation.vo.User;
import com.zhc.core.service.BaseService;

import java.io.Serializable;
import java.util.List;

public interface UserService extends BaseService<User> {

    User get(Serializable id);

    List<User> findByPage(int page, Integer roleid, String username);

    int getPages(int pageSize, Integer roleid, String keyword);
}
