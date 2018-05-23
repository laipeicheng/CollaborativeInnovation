package com.zhc.collaborativeinnovation.service;

import com.zhc.collaborativeinnovation.vo.Needs;
import com.zhc.core.service.BaseService;

import java.util.List;

public interface NeedsService extends BaseService<Needs> {

    int getPages(int pageSize, int id);

    List<Needs> findByPage(int curPage, int pageSize, int id);
}
