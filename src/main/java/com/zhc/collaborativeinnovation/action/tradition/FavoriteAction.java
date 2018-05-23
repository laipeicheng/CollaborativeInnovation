package com.zhc.collaborativeinnovation.action.tradition;

import com.zhc.collaborativeinnovation.service.ArticleService;
import com.zhc.collaborativeinnovation.service.FavoriteService;
import com.zhc.collaborativeinnovation.service.WebsiteService;
import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.collaborativeinnovation.vo.Favorite;
import com.zhc.collaborativeinnovation.vo.User;
import com.zhc.collaborativeinnovation.vo.Website;
import com.zhc.core.action.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.List;

@Namespace("/favorite")
@ParentPackage("struts-default")
@Controller
public class FavoriteAction extends BaseAction {

    @Autowired
    @Qualifier("articleService")
    private ArticleService articleService;

    @Autowired
    @Qualifier("favoriteService")
    private FavoriteService favoriteService;

    @Autowired
    @Qualifier("websiteService")
    private WebsiteService websiteService;

    private List<Article> articleList;

    private Website website;

    private List<Website> websiteList;

    private int articleid;

    private int websitePages = 1;

    private int websiteCurrPage = 1;

    @Action(value = "favoritelist", results = {@Result(name = "success", type = "freemarker", location = "favoritelist.ftl")})
    public String favoritelist() {
        String username = getCurrUsername();
        pages = articleService.favPages(username);
        articleList = articleService.favoriteList(username, curPage);
        websitePages = websiteService.getPages(6, username);
        websiteList = websiteService.findByPage(websiteCurrPage, 6, username);
        if (website != null) {
            website = websiteService.get(Website.class, website.getId());
        }
        return SUCCESS;
    }

    @Action(value = "favoriteadd", results = {@Result(name = "success", type = "redirect", location = "/article?article.articleid=${articleid}")})
    public String favoriteadd() {
        String username = getCurrUsername();
        if (!favoriteService.isFavorite(username, articleid)) {
            Favorite favorite = new Favorite();
            favorite.setArticleid(articleid);
            favorite.setUsername(username);
            favoriteService.saveOrUpdate(favorite);
        }
        articleService.changeFavoriteCounts(articleid);
        return SUCCESS;
    }

    @Action(value = "favoritecancel", results = {@Result(name = "success", type = "redirect", location = "/article?article.articleid=${articleid}")})
    public String favoritecancel() {
        String username = getCurrUsername();
        if (favoriteService.isFavorite(username, articleid)) {
            Favorite favorite = new Favorite();
            favorite.setUsername(username);
            favorite.setArticleid(articleid);
            favoriteService.delete(favorite);
        }
        articleService.changeFavoriteCounts(articleid);
        return SUCCESS;
    }

    @Action(value = "favoritedel", results = {@Result(name = "success", type = "redirect", location = "favoritelist?websiteCurrPage=${websiteCurrPage}&curPage=${curPage}")})
    public String favoritedel() {
        return favoritecancel();
    }

    @Action(value = "websiteadd", results = {@Result(name = "success", type = "redirect", location = "favoritelist?websiteCurrPage=${websiteCurrPage}&curPage=${curPage}")})
    public String websiteadd() {
        String username = getCurrUsername();
        User user = new User();
        user.setUsername(username);
        website.setUser(user);
        websiteService.saveOrUpdate(website);
        return SUCCESS;
    }

    @Action(value = "websitedel", results = {@Result(name = "success", type = "redirect", location = "favoritelist?websiteCurrPage=${websiteCurrPage}&curPage=${curPage}")})
    public String websitedel() {
        websiteService.delete(website);
        return SUCCESS;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public int getArticleid() {
        return articleid;
    }

    public void setArticleid(int articleid) {
        this.articleid = articleid;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }

    public List<Website> getWebsiteList() {
        return websiteList;
    }

    public void setWebsiteList(List<Website> websiteList) {
        this.websiteList = websiteList;
    }

    public int getWebsitePages() {
        return websitePages;
    }

    public void setWebsitePages(int websitePages) {
        this.websitePages = websitePages;
    }

    public int getWebsiteCurrPage() {
        return websiteCurrPage;
    }

    public void setWebsiteCurrPage(int websiteCurrPage) {
        this.websiteCurrPage = websiteCurrPage;
    }
}
