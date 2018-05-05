package com.zhc.collaborativeinnovation.action.tradition;

import com.opensymphony.xwork2.ActionSupport;
import com.zhc.collaborativeinnovation.vo.Article;
import com.zhc.collaborativeinnovation.vo.Reply;
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

@Namespace("/article")
@ParentPackage("struts-default")
@Controller
public class ArticleAction extends ActionSupport {

    private Article article;

    private Reply reply;

    private List<Reply> replyList;

    @Autowired
    @Qualifier("articleService")
    private ArticleService articleService;

    @Action(value = "article",results = {@Result(name = "success",type = "freemarker",location = "article.ftl")})
    public String article(){
        article = articleService.get(article.getArticleid());
        article = new Article(1,"publishtime","summary","content",10,20,30,new Timestamp(new Date().getTime()));
        reply = new Reply(2,"replycontent",new Timestamp(new Date().getTime()));
        replyList = new ArrayList<Reply>();
        replyList.add(reply);
        replyList.add(reply);
        replyList.add(reply);
        replyList.add(reply);
        replyList.add(reply);
        return SUCCESS;
    }
    @Action(value = "articlelist",results = {@Result(name = "success",type = "freemarker",location = "articlelist.ftl")})
    public String articlelist(){
        return SUCCESS;
    }

    @Action(value = "reply",results = {@Result(name = "success", type = "redirect", location = "/article?article.articleid=${reply.articleid}")})
    public String reply(){
        System.out.println(reply.getReplycontent());
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

}
