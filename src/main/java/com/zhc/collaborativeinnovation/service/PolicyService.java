package com.zhc.collaborativeinnovation.service;

import com.zhc.collaborativeinnovation.vo.Policy;
import com.zhc.core.service.BaseService;

import java.util.List;

public interface PolicyService extends BaseService<Policy> {

    List<Policy> listTop5();

    List<Policy> findByPage(int page, int pageSize);
}
