package com.zhc.collaborativeinnovation.service;

import com.zhc.collaborativeinnovation.vo.Result;

import java.util.List;

public interface SearchService{

    List<String> getConditionList(int page, int pageSize, String keyword);

    List<Result> getResultList(int page, int pageSize, String keyword, String condition);
}
