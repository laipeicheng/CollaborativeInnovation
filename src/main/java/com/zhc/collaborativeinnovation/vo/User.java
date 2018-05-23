package com.zhc.collaborativeinnovation.vo;

import com.google.gson.annotations.Expose;
import com.zhc.core.vo.BaseEntity;
import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @Expose
    @Column(name = "username")
    private String username;

    @Expose
    @Column(name = "realname")
    private String realname;

    @Expose
    @Column(name = "password")
    private String password;

    @Expose
    @Column(name = "phone")
    private String phone;

    @Expose
    @Column(name = "lastlogintime")
    private Timestamp lastlogintime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleid")
    private Role role;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "corporation")
    @JoinColumn(name = "corporation")
    private Enterprise enterprise;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "username")
    private Set<Reply> replySet;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "author")
    private Set<Article> articleSet;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "username")
    private Set<Website> websiteSet;

    public User() {
    }

    public User(String username, String realname, String password, String phone) {
        this.username = username;
        this.realname = realname;
        this.password = password;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @JSON(serialize = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @JSON(serialize = false)
    public Set<Reply> getReplySet() {
        return replySet;
    }

    public void setReplySet(Set<Reply> replySet) {
        this.replySet = replySet;
    }

    @JSON(serialize = false)
    public Set<Article> getArticleSet() {
        return articleSet;
    }

    public void setArticleSet(Set<Article> articleSet) {
        this.articleSet = articleSet;
    }

    public Timestamp getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Timestamp lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    @JSON(serialize = false)
    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    @JSON(serialize = false)
    public Set<Website> getWebsiteSet() {
        return websiteSet;
    }

    public void setWebsiteSet(Set<Website> websiteSet) {
        this.websiteSet = websiteSet;
    }
}
