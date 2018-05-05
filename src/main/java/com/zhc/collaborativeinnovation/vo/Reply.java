package com.zhc.collaborativeinnovation.vo;

import com.google.gson.annotations.Expose;
import com.zhc.core.vo.BaseEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "reply")
public class Reply extends BaseEntity {

    @Id
    @Expose
    @Column(name = "replyid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer replyid;

    @Expose
    @Column(name = "replycontent")
    private String replycontent;

    @Expose
    @Column(name = "replytime")
    private Timestamp replytime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "articleid")
    private Article article;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private User user;

    public Reply() {
    }

    public Reply(Integer replyid, String replycontent, Timestamp replytime) {
        this.replyid = replyid;
        this.replycontent = replycontent;
        this.replytime = replytime;
    }

    public Integer getReplyid() {
        return replyid;
    }

    public void setReplyid(Integer replyid) {
        this.replyid = replyid;
    }


    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent;
    }


    public Timestamp getReplytime() {
        return replytime;
    }

    public void setReplytime(Timestamp replytime) {
        this.replytime = replytime;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
