package com.zhc.collaborativeinnovation.service;

import com.zhc.collaborativeinnovation.vo.Enterprise;
import com.zhc.core.service.BaseService;

import java.util.List;

public interface EnterpriseService extends BaseService<Enterprise> {

    Enterprise getByUsername(String username);

    List<Enterprise> listByStatus(int curPage, int status);

    int getPagesByStatus(int status);
}
