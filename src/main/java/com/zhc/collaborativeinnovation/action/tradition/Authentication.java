package com.zhc.collaborativeinnovation.action.tradition;

import com.zhc.collaborativeinnovation.service.EnterpriseService;
import com.zhc.collaborativeinnovation.service.UserService;
import com.zhc.collaborativeinnovation.vo.Enterprise;
import com.zhc.collaborativeinnovation.vo.Role;
import com.zhc.collaborativeinnovation.vo.User;
import com.zhc.core.action.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Namespace("/auth")
@ParentPackage("struts-default")
@Controller
public class Authentication extends BaseAction {

    private Enterprise enterprise;

    @Autowired
    @Qualifier("enterpriseService")
    private EnterpriseService enterpriseService;

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Action(value = "authenticate", results = {@Result(name = "success", type = "redirect", location = "/enterprise/authenticationlist")})
    public String authenticate() {
        Enterprise enterprise = enterpriseService.get(Enterprise.class, this.enterprise.getId());
        enterprise.setStatus(this.enterprise.getStatus());
        User user = userService.get(enterprise.getCorporation().getUsername());
        Role role = new Role();
        System.out.println(enterprise.getStatus());
        if (Enterprise.SUCCESS == enterprise.getStatus()) {
            role.setRoleid(1);
        } else {
            role.setRoleid(2);
        }
        user.setRole(role);
        userService.saveOrUpdate(user);
        enterpriseService.saveOrUpdate(enterprise);
        return SUCCESS;
    }

    @Action(value = "reauthenticate", results = {@Result(name = "success", type = "redirect", location = "/enterprise/enterpriselist")})
    public String reauthenticate() {
        return authenticate();
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}
