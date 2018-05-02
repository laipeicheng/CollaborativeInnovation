package com.zhc.collaborativeinnovation.action.tradition;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

@Namespace("/user")
@ParentPackage("struts-default")
@Controller
public class UserAction extends ActionSupport {

    @Action(value = "userlist",results = {@Result(name = "success", type = "freemarker", location = "userlist.ftl")})
    public String userlist(){
        return SUCCESS;
    }

    @Action(value = "register",results = {@Result(name = "success",type = "redirect",location = "/login")})
    public String register(){
        return SUCCESS;
    }

    @Action(value = "login",results = {@Result(name = "success",type = "redirect",location = "/index")})
    public String login(){
        System.out.println();
        return SUCCESS;
    }
}
