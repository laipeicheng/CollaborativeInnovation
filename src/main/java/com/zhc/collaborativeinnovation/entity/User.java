package com.zhc.collaborativeinnovation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "realname")
    private String realname;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "roleid")
    private Integer roleid;

    public User() {
    }

    public User(String username, String realname, String password, String email, String phone, Integer roleid) {
        this.username = username;
        this.realname = realname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.roleid = roleid;
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

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;
        if (realname != null ? !realname.equals(user.realname) : user.realname != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        return roleid != null ? roleid.equals(user.roleid) : user.roleid == null;
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + (realname != null ? realname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (roleid != null ? roleid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{\n\tusername : " + username + ",\n\trealname : " + realname + ",\n\tpassword : " + password + ",\n\temail : " + email + ",\n\tphone : " + phone + ",\n\troleid : " + roleid + "\n}";
    }

}
