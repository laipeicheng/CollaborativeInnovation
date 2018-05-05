package com.zhc.collaborativeinnovation.action.async;

import com.opensymphony.xwork2.ActionSupport;
import com.zhc.collaborativeinnovation.service.ArticleService;
import com.zhc.collaborativeinnovation.service.impl.ArticleServiceImpl;
import com.zhc.collaborativeinnovation.vo.Article;
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
@ParentPackage("json-default")
@Controller
public class RecommendAction extends ActionSupport {

    private String sortKey;

    private List<Article> articleList;

    @Autowired
    @Qualifier("articleService")
    private ArticleService articleService;

    @Action(value = "recommend", results = {@Result(type = "json")})
    public String recommend(){
        System.out.println("---------------recommend--"+sortKey+"---------------");
        if("pageview".equals(sortKey)){
            articleList = articleService.listSortByPageview();
        }else if("favoritecount".equals(sortKey)){
            articleList = articleService.listSortByFavoritecount();
        }else if("recentReply".equals(sortKey)){
            articleList = articleService.listSortByRecentReply();
        }
        System.out.println(articleList);
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
