package com.zhc.collaborativeinnovation.vo;

import com.google.gson.annotations.Expose;
import com.zhc.core.vo.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "reply")
public class Reply extends BaseEntity {

    @Id
    @Expose
    @Column(name = "replyid")
    private Integer replyid;

    @Expose
    @Column(name = "replycontent")
    private String replycontent;

    @Expose
    @Column(name = "replytime")
    private Timestamp replytime;

    @Column(name = "username")
    private String username;

    @Expose
    @Column(name = "articleid")
    private String articleid;

    public Reply() {
    }

    public Reply(Integer replyid, String replycontent, Timestamp replytime, String username, String articleid) {
        this.replyid = replyid;
        this.replycontent = replycontent;
        this.replytime = replytime;
        this.username = username;
        this.articleid = articleid;
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


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

}
