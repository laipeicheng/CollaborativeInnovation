package com.zhc.collaborativeinnovation.action.async;

import com.opensymphony.xwork2.ActionSupport;
import com.zhc.collaborativeinnovation.entity.Article;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Namespace("/")
@ParentPackage("json-default")
@Controller
public class ArticleAsyncAction extends ActionSupport {

    private String sortKey;

    private List<Article> articleList;

    @Action(value = "recommend", results = {@Result(type = "json")})
    public String recommend(){
        System.out.println("---------------recommend--"+sortKey+"---------------");
        Article article = new Article("123456","","","",0,0,0,new Timestamp(new Date().getTime()),0);
        if("pageview".equals(sortKey)){
            article.setTitle("pageview");
        }else if("favoritecount".equals(sortKey)){
            article.setTitle("favoritecount");
        }else if("recentReply".equals(sortKey)){
            article.setTitle("recentReply");
        }
        articleList = new ArrayList<Article>();
        articleList.add(article);
        articleList.add(article);
        articleList.add(article);
        articleList.add(article);
        articleList.add(article);
        articleList.add(article);
        return SUCCESS;
    }

    public String getSortKey() {
        return sortKey;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
