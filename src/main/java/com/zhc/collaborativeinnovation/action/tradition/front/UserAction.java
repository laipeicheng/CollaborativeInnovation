package com.zhc.collaborativeinnovation.action.tradition.front;

import com.zhc.collaborativeinnovation.service.UserService;
import com.zhc.collaborativeinnovation.vo.User;
import com.zhc.core.action.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Namespace("/")
@ParentPackage("struts-default")
@Controller("frontUser")
public class UserAction extends BaseAction {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    private User user;

    @Action(value = "userinfo", results = {@Result(name = "success", type = "freemarker", location = "userinfo.ftl")})
    public String userinfo() {
        String username;
        if (user == null || "".equals(user.getUsername())) {
            username = getCurrUsername();
        } else {
            username = user.getUsername();
        }
        user = userService.get(username);
        return SUCCESS;
    }

    @Action(value = "login", results = {@Result(name = "success", type = "freemarker", location = "login.ftl")})
    public String login() {
        msg = (String) getSession().getAttribute("msg");
        getSession().removeAttribute("msg");
        return SUCCESS;
    }

    @Action(value = "register", results = {@Result(name = "success", type = "freemarker", location = "register.ftl")})
    public String register() {
        msg = (String) getSession().getAttribute("msg");
        getSession().removeAttribute("msg");
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
