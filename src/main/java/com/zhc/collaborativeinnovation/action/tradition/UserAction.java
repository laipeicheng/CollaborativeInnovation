package com.zhc.collaborativeinnovation.action.tradition;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

@Namespace("/")
@ParentPackage("struts-default")
@Controller
public class UserAction extends ActionSupport {

    @Action(value = "usercenter",results = {@Result(name = "success", type = "freemarker", location = "usercenter.ftl")})
    public String userCenter(){

        return SUCCESS;
    }

    @Action(value = "user/userlist",results = {@Result(name = "success", type = "freemarker", location = "userlist.ftl")})
    public String userlist(){
        return SUCCESS;
    }
}
