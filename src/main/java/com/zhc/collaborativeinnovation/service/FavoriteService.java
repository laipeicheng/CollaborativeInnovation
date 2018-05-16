package com.zhc.collaborativeinnovation.service;

import com.zhc.collaborativeinnovation.vo.Favorite;
import com.zhc.core.service.BaseService;

public interface FavoriteService extends BaseService<Favorite> {

    boolean isFavorite(String username, int articleid);
}
