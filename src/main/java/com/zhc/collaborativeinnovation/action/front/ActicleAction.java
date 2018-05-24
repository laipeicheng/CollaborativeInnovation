package com.zhc.collaborativeinnovation.action.front;

import com.zhc.collaborativeinnovation.service.ArticleService;
import com.zhc.collaborativeinnovation.service.ReplyService;
import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.collaborativeinnovation.vo.Articletype;
import com.zhc.collaborativeinnovation.vo.Reply;
import com.zhc.collaborativeinnovation.vo.User;
import com.zhc.core.action.BaseAction;
import com.zhc.core.realms.LoginRealm;
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

@Namespace("/")
@ParentPackage("struts-default")
@Controller("frontActicle")
public class ActicleAction extends BaseAction {

    @Autowired
    @Qualifier("articleService")
    private ArticleService articleService;

    @Autowired
    @Qualifier("baseService")
    private BaseService<Articletype> articletypeService;

    @Autowired
    @Qualifier("replyService")
    private ReplyService replyService;

    private int articletypeid = 1;

    private Reply reply;

    private User user;

    private List<Article> articleList;

    private List<Articletype> articletypeList;

    private List<Article> pageviewArticleList;

    private List<Reply> replyList;

    private Article article;

    @Action(value = "articlelist", results = {@Result(name = "success", type = "freemarker", location = "articlelist.ftl")})
    public String articlelist() {
        log.info("articlelist");
        msg = (String) getSession().getAttribute("msg");
        getSession().removeAttribute("msg");
        articleList = articleService.listByArticletype(articletypeid, curPage);
        articletypeList = articletypeService.list(Articletype.class);
        pages = articleService.getPages(articletypeid, null);
        return SUCCESS;
    }

    @Action(value = "article", results = {
            @Result(name = "success", type = "freemarker", location = "article.ftl")
            , @Result(name = "error", type = "redirect", location = "articlelist")})
    public String article() {
        log.info("article:{},{}", article.getArticleid(), article.getTitle());
        if (article == null) {
            msg = "该文章已不存在";
            getSession().setAttribute("msg", msg);
            return ERROR;
        } else {
            article = articleService.get(article.getArticleid());
            article.setPageview(article.getPageview() + 1);
            article.setReviewcount(replyService.getCounts(article.getArticleid()));
            articleService.saveOrUpdate(article);
            replyList = replyService.listByPageInUser(article.getArticleid(), curPage);
            pages = replyService.getPages(article.getArticleid());
            articleList = articleService.listSortByPageview();
            articletypeList = articletypeService.list(Articletype.class);
            return SUCCESS;
        }
    }

    @Action(value = "reply", results = {
            @Result(name = "success", type = "redirect", location = "/article?article.articleid=${reply.article.articleid}")
            , @Result(name = "error", type = "redirect", location = "/login")})
    public String reply() {
        log.info("reply:{}", reply.getReplycontent());
        Timestamp replytime = new Timestamp(new Date().getTime());
        LoginRealm.ShiroUser shiroUser = getShiroUser();
        if (shiroUser == null) {
            return ERROR;
        }
        user = new User();
        user.setUsername(shiroUser.getUsername());
        reply.setUser(user);
        reply.setReplytime(replytime);
        replyService.saveOrUpdate(reply);
        return SUCCESS;
    }

    @Action(value = "delReply", results = {@Result(name = "success", type = "redirect", location = "/article?article.articleid=${reply.article.articleid}")})
    public String delReply() {
        log.info("delReply:{}", reply.getReplyid());
        LoginRealm.ShiroUser shiroUser = getShiroUser();
        String username = shiroUser.getUsername();
        reply = replyService.get(reply.getReplyid());
        User user = reply.getArticle().getAuthor();
        if (username.equals(user.getUsername()) || "admin".equals(username)) {
            replyService.delete(reply);
        }
        return SUCCESS;
    }

    public int getArticletypeid() {
        return articletypeid;
    }

    public void setArticletypeid(int articletypeid) {
        this.articletypeid = articletypeid;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<Article> getPageviewArticleList() {
        return pageviewArticleList;
    }

    public void setPageviewArticleList(List<Article> pageviewArticleList) {
        this.pageviewArticleList = pageviewArticleList;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
