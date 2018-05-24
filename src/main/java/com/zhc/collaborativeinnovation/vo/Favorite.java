package com.zhc.collaborativeinnovation.vo;

import com.google.gson.annotations.Expose;
import com.zhc.core.vo.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "favorite")
public class Favorite extends BaseEntity {

    @Id
    @Expose
    @Column(name = "username")
    private String username;

    @Id
    @Expose
    @Column(name = "articleid")
    private Integer articleid;

    public Favorite() {
    }

    public Favorite(String username, Integer articleid) {
        this.username = username;
        this.articleid = articleid;
    }

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
