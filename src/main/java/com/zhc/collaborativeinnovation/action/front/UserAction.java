package com.zhc.collaborativeinnovation.action.front;

import com.zhc.collaborativeinnovation.service.UserService;
import com.zhc.collaborativeinnovation.vo.Role;
import com.zhc.collaborativeinnovation.vo.User;
import com.zhc.core.action.BaseAction;
import com.zhc.core.util.EncryptUtil;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Namespace("/")
@ParentPackage("struts-default")
@Controller("frontUser")
public class UserAction extends BaseAction {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    private User user;

    private String code;

    @Action(value = "userinfo", results = {@Result(name = "success", type = "freemarker", location = "userinfo.ftl")})
    public String userinfo() {
        log.info("userinfo");
        String username = "";
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
        log.info("login");
        msg = (String) getSession().getAttribute("msg");
        getSession().removeAttribute("msg");
        return SUCCESS;
    }

    @Action(value = "register", results = {@Result(name = "success", type = "freemarker", location = "register.ftl")})
    public String register() {
        log.info("register");
        msg = (String) getSession().getAttribute("msg");
        getSession().removeAttribute("msg");
        return SUCCESS;
    }

    @Action(value = "updatepwd", results = {
            @Result(name = "success", type = "redirect", location = "/login"),
            @Result(name = "error", type = "redirect", location = "/forget")})
    public String updatepwd() {
        log.info("updatepwd");
        User userTmp = userService.get(user.getUsername());
        if (userTmp != null && code != null && !"".equals(code)) {
            Map<String, String> verifyCodeMap = (Map<String, String>) getSession().getAttribute("verifyCodeMap");
            if (verifyCodeMap != null) {
                String verifyCode = verifyCodeMap.get(user.getPhone());
                if (code.equals(verifyCode)) {
                    if (verifyCodeMap.containsKey(user.getPhone())) {
                        verifyCodeMap.remove(user.getPhone());
                        getSession().setAttribute("verifyCodeMap", verifyCodeMap);
                    }
                    userTmp.setPassword(EncryptUtil.encMD5(user.getPassword(), user.getUsername()));
                    userService.saveOrUpdate(userTmp);
                    msg = "修改密码成功";
                } else {
                    msg = "验证码错误";
                    return ERROR;
                }
                getSession().setAttribute("msg", msg);
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
