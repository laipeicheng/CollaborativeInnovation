package com.zhc.collaborativeinnovation.action.tradition;

import com.zhc.collaborativeinnovation.vo.News;
import com.zhc.core.action.BaseAction;
import com.zhc.core.service.BaseService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Namespace("/news")
@ParentPackage("struts-default")
@Controller
public class NewsAction extends BaseAction {

    @Autowired
    @Qualifier("baseService")
    private BaseService<News> newsService;

    private List<News> newsList;

    private News news;

    @Action(value = "publish", results = {@Result(name = "success", type = "redirect", location = "newslist")})
    public String publish() {
        log.info("publish:{}", news.getTitle());
        news.setPublishtime(new Timestamp(new Date().getTime()));
        newsService.saveOrUpdate(news);
        return SUCCESS;
    }

    @Action(value = "newslist", results = {@Result(name = "success", type = "freemarker", location = "newslist.ftl")})
    public String newslist() {
        log.info("newslist");
        pages = newsService.getPages(News.class, 8);
        newsList = newsService.findByPage(News.class, curPage, 8);

        return SUCCESS;
    }

    @Action(value = "newsedit", results = {@Result(name = "success", type = "freemarker", location = "newsedit.ftl")})
    public String newsedit() {
        log.info("newsedit:{}", news.getId());
        news = newsService.get(News.class, news.getId());
        return SUCCESS;
    }

    @Action(value = "newsupdate", results = {@Result(name = "success", type = "redirect", location = "newslist")})
    public String newsupdate() {
        log.info("newsupdate:{}", news.getId());
        News news = newsService.get(News.class, this.news.getId());
        news.setTitle(this.news.getTitle());
        news.setSummary(this.news.getSummary());
        news.setContent(this.news.getContent());
        newsService.saveOrUpdate(news);
        return SUCCESS;
    }

    @Action(value = "newsdel", results = {@Result(name = "success", type = "redirect", location = "newslist")})
    public String newsdel() {
        log.info("newsdel:{}", news.getId());
        newsService.delete(news);
        return SUCCESS;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
