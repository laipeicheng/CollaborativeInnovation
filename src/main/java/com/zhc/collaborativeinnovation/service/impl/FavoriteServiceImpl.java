package com.zhc.collaborativeinnovation.service.impl;

import com.zhc.collaborativeinnovation.dao.FavoriteDao;
import com.zhc.collaborativeinnovation.service.FavoriteService;
import com.zhc.collaborativeinnovation.vo.Favorite;
import com.zhc.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("favoriteService")
public class FavoriteServiceImpl extends BaseServiceImpl<Favorite> implements FavoriteService {

    @Autowired
    @Qualifier("favoriteDao")
    private FavoriteDao favoriteDao;

    @Override
    public boolean isFavorite(String username, int articleid) {
        return favoriteDao.isFavorite(username, articleid);
    }
}
