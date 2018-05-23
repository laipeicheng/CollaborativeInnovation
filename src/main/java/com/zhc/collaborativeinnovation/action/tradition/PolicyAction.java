package com.zhc.collaborativeinnovation.action.tradition;

import com.zhc.collaborativeinnovation.vo.Policy;
import com.zhc.core.action.BaseAction;
import com.zhc.core.service.BaseService;
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

@Namespace("/policy")
@ParentPackage("struts-default")
@Controller
public class PolicyAction extends BaseAction {
    @Autowired
    @Qualifier("baseService")
    private BaseService<Policy> policyService;

    private List<Policy> policyList;

    private Policy policy;

    @Action(value = "publish", results = {@Result(name = "success", type = "redirect", location = "policylist")})
    public String publish() {
        policy.setPublishtime(new Timestamp(new Date().getTime()));
        policyService.saveOrUpdate(policy);
        return SUCCESS;
    }

    @Action(value = "policylist", results = {@Result(name = "success", type = "freemarker", location = "policylist.ftl")})
    public String policylist() {
        pages = policyService.getPages(Policy.class, 8);
        policyList = policyService.findByPage(Policy.class, curPage, 8);
        return SUCCESS;
    }

    @Action(value = "policyedit", results = {@Result(name = "success", type = "freemarker", location = "policyedit.ftl")})
    public String policyedit() {
        policy = policyService.get(Policy.class, policy.getId());
        return SUCCESS;
    }

    @Action(value = "policyupdate", results = {@Result(name = "success", type = "redirect", location = "policylist")})
    public String policyupdate() {
        Policy policy = policyService.get(Policy.class, this.policy.getId());
        policy.setTitle(this.policy.getTitle());
        policy.setContent(this.policy.getContent());
        policyService.saveOrUpdate(policy);
        return SUCCESS;
    }

    @Action(value = "policydel", results = {@Result(name = "success", type = "redirect", location = "policylist")})
    public String policydel() {
        policyService.delete(policy);
        return SUCCESS;
    }

    public List<Policy> getPolicyList() {
        return policyList;
    }

    public void setPolicyList(List<Policy> policyList) {
        this.policyList = policyList;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }
}
