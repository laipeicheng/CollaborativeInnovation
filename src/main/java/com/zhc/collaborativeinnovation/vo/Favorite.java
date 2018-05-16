package com.zhc.collaborativeinnovation.vo;

import com.google.gson.annotations.Expose;
import com.zhc.core.vo.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Favorite extends BaseEntity {

    @Id
    @Expose
    @Column(name = "username")
    private String username;

    @Id
    @Expose
    @Column(name = "articleid")
    private Integer articleid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

}
