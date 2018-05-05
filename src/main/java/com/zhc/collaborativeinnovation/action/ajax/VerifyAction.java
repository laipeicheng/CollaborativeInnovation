package com.zhc.collaborativeinnovation.action.ajax;

import com.zhc.core.action.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

@Namespace("/verify")
@ParentPackage("json-default")
@Controller
public class VerifyAction extends BaseAction {

    private String username;

    private String verifyStr;

    @Action(value = "username", results = {@Result(type = "json")})
    public String verifyUsername() {
        System.out.println("username : " + username);
        verifyStr = "";
        return SUCCESS;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getVerifyStr() {
        return verifyStr;
    }

    public void setVerifyStr(String verifyStr) {
        this.verifyStr = verifyStr;
    }
}
