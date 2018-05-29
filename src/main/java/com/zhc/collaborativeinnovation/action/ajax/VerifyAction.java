package com.zhc.collaborativeinnovation.action.ajax;

import com.zhc.collaborativeinnovation.service.UserService;
import com.zhc.collaborativeinnovation.vo.User;
import com.zhc.core.action.BaseAction;
import com.zhc.core.util.EncryptUtil;
import com.zhc.core.util.SMSUtil;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Namespace("/verify")
@ParentPackage("json-default")
@Controller
public class VerifyAction extends BaseAction {

    private String username;

    private String password;

    private String verifyStr;

    private String phone;

    private String code;

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    /**
     * 校验用户名
     *
     * @return
     */
    @Action(value = "username", results = {@Result(type = "json")})
    public String verifyUsername() {
        User user = userService.get(username);
        if (user != null) {
            verifyStr = "用户名已存在";
        } else {
            verifyStr = "";
        }
        return SUCCESS;
    }

    /**
     * 校验密码
     *
     * @return
     */
    @Action(value = "password", results = {@Result(type = "json")})
    public String verifyPassword() {
        String currPwd = userService.get(username).getPassword();
        password = EncryptUtil.encMD5(password, username);
        if (!password.equals(currPwd)) {
            verifyStr = "当前密码错误";
        }
        return SUCCESS;
    }

    /**
     * 发送手机验证码
     *
     * @return
     */
    @Action(value = "sendCode", results = {@Result(type = "json")})
    public String sendCode() {
        log.info("sendCode-phone:{}", phone);
        Random random = new Random();
        String verifyCode = EncryptUtil.encMD5(phone, username);
        if(userService.isExist(username, phone)){
            verifyStr = "notExist";
        }else {
            int f = random.nextInt(verifyCode.length() - 6);
            verifyCode = verifyCode.substring(f, f + 6);
            if (SMSUtil.sendCode(phone, verifyCode)) {
                Map<String, String> verifyCodeMap = (Map<String, String>) getSession().getAttribute("verifyCodeMap");
                if (verifyCodeMap == null) {
                    verifyCodeMap = new HashMap<>();
                }
                if (verifyCodeMap.containsKey(phone)) {
                    verifyCodeMap.remove(phone);
                }
                verifyCodeMap.put(phone, verifyCode);
                getSession().setAttribute("verifyCodeMap", verifyCodeMap);
                verifyStr = "success";
            } else {
                verifyStr = "error";
            }
        }
        return SUCCESS;
    }

    @Action(value = "code", results = {@Result(type = "json")})
    public String code() {
        log.info("code-code:{}", code);
        Map<String, String> verifyCodeMap = (Map<String, String>) getSession().getAttribute("verifyCodeMap");
        if (verifyCodeMap != null) {
            String verifyCode = verifyCodeMap.get(phone);
            if (code.equals(verifyCode)) {
                verifyStr = "";
            } else {
                verifyStr = "验证码错误";
            }
        } else {
            verifyStr = "验证码错误";
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
