package com.zhc.collaborativeinnovation.action.tradition;

import com.opensymphony.xwork2.ActionSupport;
import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.collaborativeinnovation.vo.Articletype;
import com.zhc.collaborativeinnovation.vo.User;
import com.zhc.collaborativeinnovation.service.ArticleService;
import com.zhc.core.service.BaseService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Namespace("/")
@ParentPackage("struts-default")
@Controller
public class IndexAction extends ActionSupport {

    private User user;

    @Autowired
    @Qualifier("articleService")
    private ArticleService articleService;

    @Autowired
    @Qualifier("baseService")
    private BaseService<Articletype> articletypeService;

    private int articletypeid = 1;

    private List<Article> articleList;

    private List<Articletype> articletypeList;

    private List<Article> pageviewArticleList;

    private Article article;

    @Action(value = "index", results = {@Result(name = "success", type = "freemarker", location = "index.ftl")})
    public String index() {
        articleList = articleService.listSortByPublishtime();
        pageviewArticleList = articleService.listSortByPageview();
        return SUCCESS;
    }

    @Action(value = "usercenter",results = {@Result(name = "success", type = "freemarker", location = "usercenter.ftl")})
    public String userCenter(){

        return SUCCESS;
    }

    @Action(value = "articlelist",results = {@Result(name = "success",type = "freemarker",location = "articlelist.ftl")})
    public String articlelist(){
        articleList = articleService.listByArticletype(articletypeid,0);
        articletypeList = articletypeService.list(Articletype.class);
        return SUCCESS;
    }
    @Action(value = "article",results = {@Result(name = "success",type = "freemarker",location = "article.ftl")})
    public String article(){
        article = articleService.get(article.getArticleid());
        return SUCCESS;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Article> getPageviewArticleList() {
        return pageviewArticleList;
    }

    public void setPageviewArticleList(List<Article> pageviewArticleList) {
        this.pageviewArticleList = pageviewArticleList;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<Articletype> getArticletypeList() {
        return articletypeList;
    }

    public void setArticletypeList(List<Articletype> articletypeList) {
        this.articletypeList = articletypeList;
    }

    public int getArticletypeid() {
        return articletypeid;
    }

    public void setArticletypeid(int articletypeid) {
        this.articletypeid = articletypeid;
    }
}
