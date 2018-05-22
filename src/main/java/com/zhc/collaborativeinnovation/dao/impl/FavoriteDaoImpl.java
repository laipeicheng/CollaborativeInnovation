package com.zhc.collaborativeinnovation.dao.impl;

import com.zhc.collaborativeinnovation.dao.FavoriteDao;
import com.zhc.collaborativeinnovation.vo.Favorite;
import com.zhc.core.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository("favoriteDao")
public class FavoriteDaoImpl extends BaseDaoImpl<Favorite> implements FavoriteDao {

    @Override
    public boolean isFavorite(String username, int articleid) {
        String hql = "select count(*) from Favorite where username=? and articleid=?";
        long count = (Long) hibernateTemplate.find(hql, username, articleid).listIterator().next();
        if(count>0)
            return true;
        return false;
    }

    @Override
    public int getFavoriteCounts(int articleid) {
        String hql = "select count(*) from Favorite where articleid=?";
        long count = (Long) hibernateTemplate.find(hql, articleid).listIterator().next();
        return (int) count;
    }
}
