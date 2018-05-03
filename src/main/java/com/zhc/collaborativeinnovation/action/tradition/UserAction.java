package com.zhc.collaborativeinnovation.action.tradition;

import com.opensymphony.xwork2.ActionSupport;
import com.zhc.collaborativeinnovation.vo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

@Namespace("/user")
@ParentPackage("struts-default")
@Controller
public class UserAction extends ActionSupport {

    private User user;

    @Action(value = "userlist", results = {@Result(name = "success", type = "freemarker", location = "userlist.ftl")})
    public String userlist() {
        return SUCCESS;
    }

    @Action(value = "register", results = {@Result(name = "success", type = "redirect", location = "/login")})
    public String register() {
        return SUCCESS;
    }

    @Action(value = "login", results = {@Result(name = "success", type = "redirect", location = "/index")})
    public String login() {
        Subject subject = SecurityUtils.getSubject();

        if (subject.isAuthenticated()) {
            subject.logout();
        }

        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            try {
            subject.login(token);

            }catch (UnknownAccountException e){
                System.out.println(e.getMessage());
            }
        }

        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
