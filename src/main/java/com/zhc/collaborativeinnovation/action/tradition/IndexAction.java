package com.zhc.collaborativeinnovation.action.tradition;

import com.opensymphony.xwork2.ActionSupport;
import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.collaborativeinnovation.vo.User;
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

    private List<Article> pageviewArticleList;

    private Article article;

    @Action(value = "index", results = {@Result(name = "success", type = "freemarker", location = "index.ftl")})
    public String index() {
        articleList = articleService.listSortByPublishtime();
        pageviewArticleList = articleService.listSortByPageview();
        Article article = new Article("123456","publishtime","summary","content",10,20,30,new Timestamp(new Date().getTime()),2);
        articleList = new ArrayList<Article>();
        articleList.add(article);
        articleList.add(article);
        articleList.add(article);
        articleList.add(article);
        articleList.add(article);
        articleList.add(article);
        pageviewArticleList = articleList;
        return SUCCESS;
    }

    @Action(value = "usercenter",results = {@Result(name = "success", type = "freemarker", location = "usercenter.ftl")})
    public String userCenter(){

        return SUCCESS;
    }

    @Action(value = "articlelist",results = {@Result(name = "success",type = "freemarker",location = "articlelist.ftl")})
    public String articlelist(){
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
    @Action(value = "article",results = {@Result(name = "success",type = "freemarker",location = "article.ftl")})
    public String article(){
        article = articleService.get(article.getArticleid());
        article = new Article("123456","publishtime","summary","content",10,20,30,new Timestamp(new Date().getTime()),2);
        /*reply = new Reply(2,"replycontent",new Timestamp(new Date().getTime()),"username","123456");
        replyList = new ArrayList<Reply>();
        replyList.add(reply);
        replyList.add(reply);
        replyList.add(reply);
        replyList.add(reply);
        replyList.add(reply);*/
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
}
