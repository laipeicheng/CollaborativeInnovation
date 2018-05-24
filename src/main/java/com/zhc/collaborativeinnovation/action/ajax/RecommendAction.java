package com.zhc.collaborativeinnovation.action.ajax;

import com.zhc.collaborativeinnovation.service.ArticleService;
import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.core.action.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.List;

@Namespace("/")
@ParentPackage("json-default")
@Controller
public class RecommendAction extends BaseAction {

    private String sortKey;

    private List<Article> articleList;

    @Autowired
    @Qualifier("articleService")
    private ArticleService articleService;

    /**
     * 获取排行文章列表
     *
     * @return
     */
    @Action(value = "recommend", results = {@Result(type = "json")})
    public String recommend() {
        if ("pageview".equals(sortKey)) {
            articleList = articleService.listSortByPageview();
        } else if ("recentReply".equals(sortKey)) {
            articleList = articleService.listSortByRecentReply();
        }
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
