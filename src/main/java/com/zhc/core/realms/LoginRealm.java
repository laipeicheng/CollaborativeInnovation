package com.zhc.core.realms;

import com.google.gson.annotations.Expose;
import com.zhc.collaborativeinnovation.vo.User;
import com.zhc.collaborativeinnovation.service.UserService;
import com.zhc.core.util.EncryptUtil;
import com.zhc.core.vo.BaseEntity;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class LoginRealm extends AuthorizingRealm {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    /**
     * 授权
     * 用户第一次查询权限时调用
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        System.out.println("----------------doGetAuthorizationInfo--------------");
        ShiroUser shiroUser = (ShiroUser) principals;
        User user = userService.get(shiroUser.getUsername());
        Set<String> roles = new HashSet<String>();
        roles.add(user.getRole().getRolename());
        AuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        return info;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {
        System.out.println("----------------doGetAuthenticationInfo-------------");
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        String password = upToken.getPassword().toString();
        AuthenticationInfo info = null;
        if (username != null && !"".equals(username)) {
            User user = userService.get(username);
            if (user != null) {
                ByteSource salt = ByteSource.Util.bytes(username);
                password = EncryptUtil.encMD5(password,salt);
                if(password.equals(user.getPassword())){
                    throw new IncorrectCredentialsException();
                }else {
                    ShiroUser shiroUser = new ShiroUser(username, user.getRealname(), user.getPassword());
                    info = new SimpleAuthenticationInfo(shiroUser, user.getPassword(), salt, this.getName());
                }
            } else {
                throw new UnknownAccountException();
            }
        }
        return info;
    }

    public class ShiroUser extends BaseEntity {

        @Expose
        private String username;

        @Expose
        private String realname;

        @Expose
        private String password;

        public ShiroUser() {
        }

        public ShiroUser(String username, String realname, String password) {
            this.username = username;
            this.realname = realname;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }
    }
}