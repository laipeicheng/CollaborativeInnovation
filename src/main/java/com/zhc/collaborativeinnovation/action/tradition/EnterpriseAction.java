package com.zhc.collaborativeinnovation.action.tradition;

import com.zhc.collaborativeinnovation.service.EnterpriseService;
import com.zhc.collaborativeinnovation.vo.Enterprise;
import com.zhc.core.action.BaseAction;
import com.zhc.core.realms.LoginRealm;
import com.zhc.core.service.BaseService;
import com.zhc.core.util.FileUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.util.List;

@Namespace("/enterprise")
@ParentPackage("struts-default")
@Controller
public class EnterpriseAction extends BaseAction {

    private String fileUrl;

    private Enterprise enterprise;

    private List<Enterprise> enterpriseList;

    @Autowired
    @Qualifier("enterpriseService")
    private EnterpriseService enterpriseService;

    @Action(value = "auth", results = {@Result(name = "success", type = "redirect", location = "enterpriseinfo")})
    public String auth() {
        Subject subject = SecurityUtils.getSubject();
        LoginRealm.ShiroUser shiroUser = (LoginRealm.ShiroUser) subject.getPrincipal();
        if (null != shiroUser) {
            String username = shiroUser.getUsername();
            enterprise = enterpriseService.getByUsername(username);
            if (enterprise == null||Enterprise.REAUTH==enterprise.getStatus()) {
                byte[] bytes = FileUtil.getFile(fileUrl);
                enterprise.setLicense(bytes);
                enterprise.setStatus(Enterprise.REQUEST);
                enterprise.setCorporation(username);
                enterpriseService.saveOrUpdate(enterprise);
                FileUtil.delFile(fileUrl);
            }
        }
        return SUCCESS;
    }

    @Action(value = "authentication", results = {@Result(name = "success", type = "freemarker", location = "authentication.ftl")
            , @Result(name = "enterpriseinfo", type = "chain", params = {"actionName", "enterpriseinfo", "namespace", "enterprise"})})
    public String authentication() {
        Subject subject = SecurityUtils.getSubject();
        LoginRealm.ShiroUser shiroUser = (LoginRealm.ShiroUser) subject.getPrincipal();
        String username = shiroUser.getUsername();
        enterprise = enterpriseService.getByUsername(username);
        if (enterprise == null||Enterprise.REAUTH==enterprise.getStatus()) {
            return SUCCESS;
        } else {
            return "enterpriseinfo";
        }
    }

    @Action(value = "authenticationlist",results = {@Result(name = "success",type = "freemarker",location = "authenticationlist.ftl")})
    public String authenticationlist(){
        pages = enterpriseService.getPagesByStatus(Enterprise.REQUEST);
        enterpriseList = enterpriseService.listByStatus(curPage, Enterprise.REQUEST);
        return SUCCESS;
    }

    @Action(value = "enterpriselist",results = {@Result(name = "success",type = "freemarker",location = "enterpriselist.ftl")})
    public String enterpriselist(){
        pages = enterpriseService.getPagesByStatus(Enterprise.SUCCESS);
        enterpriseList = enterpriseService.listByStatus(curPage, Enterprise.SUCCESS);
        return SUCCESS;
    }

    @Action(value = "enterpriseinfo", results = {@Result(name = "success", type = "freemarker", location = "enterpriseinfo.ftl")})
    public String enterpriseinfo() {
        if(enterprise == null) {
            Subject subject = SecurityUtils.getSubject();
            LoginRealm.ShiroUser shiroUser = (LoginRealm.ShiroUser) subject.getPrincipal();
            String username = shiroUser.getUsername();
            enterprise = enterpriseService.getByUsername(username);
        }else{
            enterprise = enterpriseService.get(Enterprise.class, enterprise.getId());
        }
        return SUCCESS;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public List<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(List<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
}
