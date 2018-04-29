package com.zhc.collaborativeinnovation.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "reply")
public class Reply implements Serializable {

    @Id
    @Column(name = "replyid")
    private Integer replyid;

    @Column(name = "replycontent")
    private String replycontent;

    @Column(name = "replytime")
    private Timestamp replytime;

    @Column(name = "username")
    private String username;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reply reply = (Reply) o;

        if (replyid != null ? !replyid.equals(reply.replyid) : reply.replyid != null) return false;
        if (replycontent != null ? !replycontent.equals(reply.replycontent) : reply.replycontent != null) return false;
        if (replytime != null ? !replytime.equals(reply.replytime) : reply.replytime != null) return false;
        if (username != null ? !username.equals(reply.username) : reply.username != null) return false;
        if (articleid != null ? !articleid.equals(reply.articleid) : reply.articleid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = replyid != null ? replyid.hashCode() : 0;
        result = 31 * result + (replycontent != null ? replycontent.hashCode() : 0);
        result = 31 * result + (replytime != null ? replytime.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (articleid != null ? articleid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{\n\treplyid : " + replyid + ",\n\treplycontent : " + replycontent + ",\n\treplytime : " + replytime + ",\n\tusername : " + username + ",\n\tarticleid : " + articleid + "\n}";
    }
}
