package com.zhc.collaborativeinnovation.action.tradition;

import com.zhc.collaborativeinnovation.service.UserService;
import com.zhc.collaborativeinnovation.vo.Role;
import com.zhc.collaborativeinnovation.vo.User;
import com.zhc.core.action.BaseAction;
import com.zhc.core.realms.LoginRealm;
import com.zhc.core.util.EncryptUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Namespace("/user")
@ParentPackage("struts-default")
@Controller
public class UserAction extends BaseAction {

    private User user;

    private String newpass;

    private List<User> userList;

    @Autowired
    @Qualifier("userService")
    private UserService userService;


    @Action(value = "userlist", results = {@Result(name = "success", type = "freemarker", location = "userlist.ftl")})
    public String userlist() {
        userList = userService.findByPage(curPage);
        pages = userService.getPages(User.class);
        return SUCCESS;
    }

    @Action(value = "register", results = {
            @Result(name = "success", type = "freemarker", location = "../login.ftl")
            , @Result(name = "error", type = "freemarker", location = "../register.ftl")})
    public String register() {
        String username = user.getUsername();
        if (userService.get(username) == null) {
            String password = user.getPassword();
            user.setPassword(EncryptUtil.encMD5(password, username));
            user.setRole(new Role(2, ""));
            userService.saveOrUpdate(user);
            msg = "注册成功";
        } else {
            msg = "注册失败";
            return ERROR;
        }
        return SUCCESS;
    }

    @Action(value = "login", results = {
            @Result(name = "success", type = "redirect", location = "/index")
            , @Result(name = "error", type = "freemarker", location = "../login.ftl")
            , @Result(name = "login", type = "freemarker", location = "../register.ftl")})
    public String login() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        if (subject.isAuthenticated()) {
            subject.logout();
            session.removeAttribute("user");
        }

        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            try {
                subject.login(token);
                user = userService.get(user.getUsername());
                user.setLastlogintime(new Timestamp(new Date().getTime()));
                userService.saveOrUpdate(user);
                session.setAttribute("user", subject.getPrincipal());
            } catch (AccountException e) {
                msg = "用户不存在,请注册";
                return "login";
            } catch (IncorrectCredentialsException e) {
                msg = "用户名或密码错误";
                return ERROR;
            }
        }

        return SUCCESS;
    }

    @Action(value = "updateinfo", results = {@Result(name = "success", type = "redirect", location = "/usercenter")})
    public String updateInfo() {
        User user = userService.get(this.user.getUsername());
        user.setEmail(this.user.getEmail());
        user.setRealname(this.user.getRealname());
        user.setPhone(this.user.getPhone());
        userService.saveOrUpdate(user);
        return SUCCESS;
    }

    @Action(value = "updatepwd", results = {@Result(name = "success", type = "redirect", location = "/usercenter")})
    public String updatePwd() {
        String username;
        String password;
        String currPwd;
        if (user == null || "".equals(user.getUsername())) {
            Subject subject = SecurityUtils.getSubject();
            user = (User) subject.getSession().getAttribute("user");
        }
        username = user.getUsername();
        user = userService.get(username);
        System.out.println(user);
        currPwd = user.getPassword();
        password = EncryptUtil.encMD5(newpass, username);
        if (!password.equals(currPwd)) {
            user.setPassword(password);
        }
        userService.saveOrUpdate(user);
        return SUCCESS;
    }

    @Action(value = "deluser", results = {@Result(name = "success", type = "redirect", location = "/user/userlist")})
    public String deluser() {
        user = userService.get(user.getUsername());
        userService.delete(user);
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNewpass() {
        return newpass;
    }

    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
