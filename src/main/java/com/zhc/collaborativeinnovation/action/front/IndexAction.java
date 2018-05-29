package com.zhc.collaborativeinnovation.action.front;

import com.zhc.collaborativeinnovation.service.ArticleService;
import com.zhc.collaborativeinnovation.service.SearchService;
import com.zhc.collaborativeinnovation.service.SettingService;
import com.zhc.collaborativeinnovation.service.impl.SearchServiceImpl;
import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.core.action.BaseAction;
import com.zhc.core.vo.Setting;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.List;

@Namespace("/")
@ParentPackage("struts-default")
@Controller
public class IndexAction extends BaseAction {

    @Autowired
    @Qualifier("articleService")
    private ArticleService articleService;

    @Autowired
    @Qualifier("settingService")
    private SettingService settingService;

    @Autowired
    @Qualifier("searchService")
    private SearchService searchService;

    private String searchKeyword;

    private String condition;

    private Setting setting;

    private List<Article> articleList;

    private List<Article> pageviewArticleList;

    private List<String> conditionList;

    private List<com.zhc.collaborativeinnovation.vo.Result> resultList;

    @Action(value = "index", results = {@Result(name = "success", type = "freemarker", location = "index.ftl")})
    public String index() {
        log.info("index");
        articleList = articleService.listSortByPublishtime();
        pageviewArticleList = articleService.listSortByPageview();
        return SUCCESS;
    }

    @Action(value = "about", results = {@Result(name = "success", type = "freemarker", location = "about.ftl")})
    public String about() {
        log.info("about");
        setting = settingService.getSetting();
        return SUCCESS;
    }

    @Action(value = "search", results = {@Result(name = "success", type = "freemarker", location = "searchresult.ftl")})
    public String search() {
        log.info("search-keyword:{}, condition:{}", searchKeyword, condition);
        conditionList = searchService.getConditionList(curPage, 6, searchKeyword);
        if (conditionList!=null&&!conditionList.isEmpty()) {
            if (condition==null||"".equals(condition)) {
                condition = conditionList.get(0);
            }
            resultList = searchService.getResultList(curPage, 6, searchKeyword, condition);
        }
        log.info("conditionList:{}", conditionList);
        return SUCCESS;
    }

    public Setting getSetting() {
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public List<Article> getPageviewArticleList() {
        return pageviewArticleList;
    }

    public void setPageviewArticleList(List<Article> pageviewArticleList) {
        this.pageviewArticleList = pageviewArticleList;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public List<String> getConditionList() {
        return conditionList;
    }

    public void setConditionList(List<String> conditionList) {
        this.conditionList = conditionList;
    }

    public List<com.zhc.collaborativeinnovation.vo.Result> getResultList() {
        return resultList;
    }

    public void setResultList(List<com.zhc.collaborativeinnovation.vo.Result> resultList) {
        this.resultList = resultList;
    }
}
