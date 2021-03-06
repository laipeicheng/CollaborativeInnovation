package com.zhc.collaborativeinnovation.action.back;

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

    private Integer articletypeid;

    private String keyword;

    @Autowired
    @Qualifier("baseService")
    private BaseService<Articletype> articletypeService;

    @Autowired
    @Qualifier("articleService")
    private ArticleService articleService;

    @Action(value = "articlelist", results = {@Result(name = "success", type = "freemarker", location = "articlelist.ftl")})
    public String articlelist() {
        log.info("articlelist");
        log.info("articletypeid:{}, keyword:{}, curPage:{},pages:{}", articletypeid, keyword, curPage, pages);
        String username = getCurrUsername();
        articletypeList = articletypeService.list(Articletype.class);
        if ("admin".equals(username)) {
            articleList = articleService.list(curPage, 8, articletypeid, keyword);
            pages = articleService.getPages(8, articletypeid, null, keyword);
        } else {
            articleList = articleService.listByUsername(username, curPage, articletypeid, keyword);
            pages = articleService.getPages(8, articletypeid, username, keyword);
        }
        if (curPage > pages){
            curPage = pages;
        }
        return SUCCESS;
    }

    @Action(value = "publish", results = {@Result(name = "success", type = "redirect", location = "articlelist")})
    public String publish() {
        log.info("publish:{}", article.getTitle());
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
        log.info("articleupdate:{}", article.getArticleid());
        Article article = articleService.get(this.article.getArticleid());

        article.setTitle(this.article.getTitle());
        article.setArticletype(this.article.getArticletype());
        article.setSummary(this.article.getSummary());
        article.setContent(this.article.getContent());

        articleService.saveOrUpdate(article);
        return SUCCESS;
    }

    @Action(value = "articledel", results = {@Result(name = "success", type = "redirect", location = "articlelist?articletypeid=${articletypeid}&keyword=${keyword}&currPage=${currPage}")})
    public String articledel() {
        log.info("articledel:{}", article.getArticleid());
        articleService.delete(article);
        return SUCCESS;
    }

    @Action(value = "articleadd", results = {@Result(name = "success", type = "freemarker", location = "articleadd.ftl")})
    public String articleadd() {
        log.info("articleadd");
        articletypeList = articletypeService.list(Articletype.class);
        return SUCCESS;
    }

    @Action(value = "articleedit", results = {@Result(name = "success", type = "freemarker", location = "articleedit.ftl")})
    public String articleedit() {
        log.info("articleedit:{}", article.getArticleid());
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

    public Integer getArticletypeid() {
        return articletypeid;
    }

    public void setArticletypeid(Integer articletypeid) {
        this.articletypeid = articletypeid;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
