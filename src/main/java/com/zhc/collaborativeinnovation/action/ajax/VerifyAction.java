package com.zhc.collaborativeinnovation.action.ajax;

import com.zhc.collaborativeinnovation.service.UserService;
import com.zhc.collaborativeinnovation.vo.User;
import com.zhc.core.action.BaseAction;
import com.zhc.core.realms.LoginRealm;
import com.zhc.core.util.EncryptUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Namespace("/verify")
@ParentPackage("json-default")
@Controller
public class VerifyAction extends BaseAction {

    private String username;

    private String password;

    private String verifyStr;

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Action(value = "username", results = {@Result(type = "json")})
    public String verifyUsername() {
        User user = userService.get(username);
        if(user != null){
            verifyStr = "用户名已存在";
        }else {
            verifyStr = "";
        }
        return SUCCESS;
    }

    @Action(value = "password", results = {@Result(type = "json")})
    public String verifyPassword() {
        Subject subject = SecurityUtils.getSubject();
        LoginRealm.ShiroUser shiroUser = (LoginRealm.ShiroUser) subject.getPrincipal();
        String currPwd = shiroUser.getPassword();
        String username = shiroUser.getUsername();
        password = EncryptUtil.encMD5(password, username);
        if(!password.equals(currPwd)){
            verifyStr = "当前密码错误";
        }
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
