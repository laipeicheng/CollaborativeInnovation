package com.zhc.collaborativeinnovation.dao;

import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.collaborativeinnovation.vo.Reply;
import com.zhc.core.dao.BaseDao;

import java.util.List;

public interface ReplyDao extends BaseDao<Reply> {

    List<Reply> listByPageInUser(int articleid, int curPage);

    int getPages(int articleid);
}
