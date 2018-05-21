package com.zhc.collaborativeinnovation.service.impl;

import com.zhc.collaborativeinnovation.dao.ReplyDao;
import com.zhc.collaborativeinnovation.service.ReplyService;
import com.zhc.collaborativeinnovation.vo.Reply;
import com.zhc.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service("replyService")
public class ReplyServiceImpl extends BaseServiceImpl<Reply> implements ReplyService {

    @Autowired
    @Qualifier("replyDao")
    private ReplyDao replyDao;

    @Override
    public Reply get(Serializable id) {
        return get(Reply.class, id);
    }

    @Override
    public List<Reply> listByPageInUser(int articleid, int curPage) {
        return replyDao.listByPageInUser(articleid, curPage);
    }

    @Override
    public int getPages(int articleid) {
        return replyDao.getPages(articleid);
    }

    @Override
    public int getCounts(int articleid) {
        return replyDao.getCounts(articleid);
    }
}
