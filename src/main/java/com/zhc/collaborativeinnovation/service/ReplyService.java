package com.zhc.collaborativeinnovation.service;

import com.zhc.collaborativeinnovation.vo.Reply;
import com.zhc.core.service.BaseService;

import java.io.Serializable;
import java.util.List;

public interface ReplyService extends BaseService<Reply> {

    Reply get(Serializable id);

    List<Reply> listByPageInUser(int articleid, int curPage);
}
