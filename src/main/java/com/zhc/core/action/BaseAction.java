package com.zhc.core.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhc.collaborativeinnovation.service.UserService;
import com.zhc.collaborativeinnovation.vo.User;
import com.zhc.core.realms.LoginRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class BaseAction extends ActionSupport {

    public Logger log = LoggerFactory.getLogger("MainLogger");

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    private HttpServletRequest request;

    private HttpServletResponse response;

    private HttpSession session;

    public int pages = 1;

    public int curPage = 1;

    public String msg;

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    public HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }

    public HttpSession getSession() {
        return getRequest().getSession();
    }

    public String getCurrUsername() {
        return getShiroUser().getUsername();
    }

    public User getCurrUser() {
        return userService.get(getCurrUsername());
    }

    public LoginRealm.ShiroUser getShiroUser() {
        Subject subject = SecurityUtils.getSubject();
        return (LoginRealm.ShiroUser) subject.getPrincipal();
    }
}
