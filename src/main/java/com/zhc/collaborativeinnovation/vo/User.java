package com.zhc.collaborativeinnovation.vo;

import com.google.gson.annotations.Expose;
import com.zhc.core.vo.BaseEntity;

import javax.persistence.*;

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
    @Column(name = "email")
    private String email;

    @Expose
    @Column(name = "phone")
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleid", referencedColumnName = "roleid",unique = true)
    private Role role;

    public User() {}

    public User(String username, String realname, String password, String email, String phone, Integer roleid) {
        this.username = username;
        this.realname = realname;
        this.password = password;
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
