package com.zhc.collaborativeinnovation.action.tradition;

import com.zhc.collaborativeinnovation.service.ArticleService;
import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.collaborativeinnovation.vo.Articletype;
import com.zhc.collaborativeinnovation.vo.Reply;
import com.zhc.collaborativeinnovation.vo.User;
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

    @Action(value = "articlelist", results = {@Result(name = "success", type = "freemarker", location = "articlelist.ftl")})
    public String articlelist() {
        log.debug("articlelist");
        String username = getCurrUsername();
        if ("admin".equals(username)) {
            articleList = articleService.list(curPage);
            pages = articleService.getPages(null, null);
        } else {
            articleList = articleService.listByUsername(username, curPage);
            pages = articleService.getPages(null, username);
        }
        return SUCCESS;
    }

    @Action(value = "publish", results = {@Result(name = "success", type = "redirect", location = "articlelist")})
    public String publish() {
        User user = new User();
        user.setUsername(getCurrUsername());
        article.setPageview(0);
        article.setReviewcount(0);
        article.setFavoritecount(0);
        article.setPublishtime(new Timestamp(new Date().getTime()));
        article.setAuthor(user);
        articleService.saveOrUpdate(article);
        return SUCCESS;
    }

    @Action(value = "articleupdate", results = {@Result(name = "success", type = "redirect", location = "articlelist")})
    public String articleupdate() {
        Article article = articleService.get(this.article.getArticleid());
        article.setTitle(this.article.getTitle());
        article.setArticletype(this.article.getArticletype());
        article.setSummary(this.article.getSummary());
        article.setContent(this.article.getContent());
        articleService.saveOrUpdate(article);
        return SUCCESS;
    }

    @Action(value = "articledel", results = {@Result(name = "success", type = "redirect", location = "articlelist")})
    public String articledel() {
        articleService.delete(article);
        return SUCCESS;
    }

    @Action(value = "articleadd", results = {@Result(name = "success", type = "freemarker", location = "articleadd.ftl")})
    public String articleadd() {
        articletypeList = articletypeService.list(Articletype.class);
        return SUCCESS;
    }

    @Action(value = "articleedit", results = {@Result(name = "success", type = "freemarker", location = "articleedit.ftl")})
    public String articleedit() {
        articletypeList = articletypeService.list(Articletype.class);
        article = articleService.get(article.getArticleid());
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
