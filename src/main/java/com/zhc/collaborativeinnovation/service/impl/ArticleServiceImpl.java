package com.zhc.collaborativeinnovation.service.impl;

import com.zhc.collaborativeinnovation.dao.ArticleDao;
import com.zhc.collaborativeinnovation.dao.FavoriteDao;
import com.zhc.collaborativeinnovation.service.ArticleService;
import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service("articleService")
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService {

    @Autowired
    @Qualifier("articleDao")
    private ArticleDao articleDao;

    @Autowired
    @Qualifier("favoriteDao")
    private FavoriteDao favoriteDao;

    @Override
    public List<Article> listSortByPublishtime() {
        return articleDao.orderBy("publishtime");
    }

    @Override
    public List<Article> listSortByPageview() {
        return articleDao.orderBy("pageview");
    }

    @Override
    public List<Article> listSortByRecentReply() {

        return articleDao.orderByRecentReply();
    }

    @Override
    public List<Article> listByArticletype(int articletypeid, int page) {
        return articleDao.listByArticletype(articletypeid, page);
    }

    @Override
    public Article get(Serializable id) {
        return this.get(Article.class, id);
    }

    @Override
    public int getPages(int pageSize, Integer articletypeid, String username, String keyword) {
        return articleDao.getPages(pageSize, articletypeid, username, keyword);
    }

    @Override
    public List<Article> listByUsername(String username, int page, Integer articletypeid, String keyword) {
        return articleDao.listByUsername(username, page, articletypeid, keyword);
    }

    @Override
    public List<Article> list(int curPage, Integer articletypeid, String keyword) {
        return articleDao.list(curPage, articletypeid, keyword);
    }

    @Override
    public List<Article> favoriteList(String username, int page) {
        return articleDao.favoriteList(username, page);
    }

    @Override
    public int favPages(String username) {
        return articleDao.favPages(username);
    }

    @Override
    public void changeFavoriteCounts(int articleid) {
        int favoritecounts = favoriteDao.getFavoriteCounts(articleid);
        Article article = get(articleid);
        article.setFavoritecount(favoritecounts);
        saveOrUpdate(article);
    }
}
