package com.zhc.collaborativeinnovation.action.tradition;

import com.opensymphony.xwork2.ActionSupport;
import com.zhc.collaborativeinnovation.entity.Article;
import com.zhc.collaborativeinnovation.entity.User;
import com.zhc.collaborativeinnovation.service.ArticleService;
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

    private List<Article> articleList;

    @Action(value = "index", results = {@Result(name = "success", type = "freemarker", location = "index.ftl")})
    public String index() {
        articleList = articleService.listSortByPublishtime();
        Article article = new Article("123456","publishtime","summary","content",10,20,30,new Timestamp(new Date().getTime()),2);
        articleList = new ArrayList<Article>();
        articleList.add(article);
        articleList.add(article);
        articleList.add(article);
        articleList.add(article);
        articleList.add(article);
        articleList.add(article);
        return SUCCESS;
    }

    @Action(value = "login",results = {@Result(name = "success",type = "redirect",location = "/index")})
    public String login(){
        System.out.println(user);
        return index();
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
}
