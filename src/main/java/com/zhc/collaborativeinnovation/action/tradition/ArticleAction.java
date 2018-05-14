package com.zhc.collaborativeinnovation.action.tradition;

import com.zhc.collaborativeinnovation.service.ArticleService;
import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.collaborativeinnovation.vo.Articletype;
import com.zhc.collaborativeinnovation.vo.Reply;
import com.zhc.collaborativeinnovation.vo.User;
import com.zhc.core.action.BaseAction;
import com.zhc.core.realms.LoginRealm;
import com.zhc.core.service.BaseService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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

@Namespace("/article")
@ParentPackage("struts-default")
@Controller
public class ArticleAction extends BaseAction {

    private Article article;

    private Reply reply;

    private List<Reply> replyList;

    private List<Article> articleList;

    private List<Articletype> articletypeList;

    @Autowired
    @Qualifier("baseService")
    private BaseService<Articletype> articletypeService;

    @Autowired
    @Qualifier("articleService")
    private ArticleService articleService;

    @Action(value = "article",results = {@Result(name = "success",type = "freemarker",location = "article.ftl")})
    public String article(){
        article = articleService.get(article.getArticleid());
        return SUCCESS;
    }
    @Action(value = "articlelist",results = {@Result(name = "success",type = "freemarker",location = "articlelist.ftl")})
    public String articlelist(){
        Subject subject = SecurityUtils.getSubject();
        LoginRealm.ShiroUser shiroUser = (LoginRealm.ShiroUser) subject.getSession().getAttribute("user");
        String username = shiroUser.getUsername();
        articleList = articleService.listByUsername(username, curPage);
        return SUCCESS;
    }

    @Action(value = "reply",results = {@Result(name = "success", type = "redirect", location = "/article?article.articleid=${reply.articleid}")})
    public String reply(){
        System.out.println(reply.getReplycontent());
        return SUCCESS;
    }

    @Action(value = "publish",results = {@Result(name = "success", type = "redirect", location = "articlelist")})
    public String publish(){
        article.setPageview(0);
        article.setReviewcount(0);
        Timestamp timestamp = new Timestamp(new Date().getTime());
        article.setPublishtime(timestamp);
        articleService.saveOrUpdate(article);
        return SUCCESS;
    }

    @Action(value = "articleadd",results = {@Result(name = "success", type = "freemarker", location = "articleadd.ftl")})
    public String articleadd(){
        articletypeList = articletypeService.list(Articletype.class);
        return SUCCESS;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {

        this.articleList = articleList;
    }

    public List<Articletype> getArticletypeList() {
        return articletypeList;
    }

    public void setArticletypeList(List<Articletype> articletypeList) {
        this.articletypeList = articletypeList;
    }
}
