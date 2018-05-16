package com.zhc.collaborativeinnovation.dao;


import com.zhc.collaborativeinnovation.vo.Favorite;
import com.zhc.core.dao.BaseDao;

public interface FavoriteDao extends BaseDao<Favorite> {

    boolean isFavorite(String username, int articleid);
}
