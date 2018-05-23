package com.zhc.collaborativeinnovation.action.tradition;

import com.zhc.collaborativeinnovation.service.EnterpriseService;
import com.zhc.collaborativeinnovation.service.NeedsService;
import com.zhc.collaborativeinnovation.vo.Enterprise;
import com.zhc.collaborativeinnovation.vo.Needs;
import com.zhc.core.action.BaseAction;
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

@Namespace("/needs")
@ParentPackage("struts-default")
@Controller
public class NeedsAction extends BaseAction {

    @Autowired
    @Qualifier("needsService")
    private NeedsService needsService;

    @Autowired
    @Qualifier("enterpriseService")
    private EnterpriseService enterpriseService;

    private List<Needs> needsList;

    private Needs needs;

    @Action(value = "publish", results = {@Result(name = "success", type = "redirect", location = "needslist")})
    public String publish() {
        String username = getCurrUsername();
        needs.setPublishtime(new Timestamp(new Date().getTime()));
        needs.setPublisher(enterpriseService.getByUsername(username));
        needs.setStatus(Needs.START);
        needsService.saveOrUpdate(needs);
        return SUCCESS;
    }

    @Action(value = "needslist", results = {@Result(name = "success", type = "freemarker", location = "needslist.ftl")})
    public String needslist() {
        String username = getCurrUsername();
        if (!"admin".equals(username)) {
            Enterprise enterprise = enterpriseService.getByUsername(username);
            pages = needsService.getPages(8, enterprise.getId());
            needsList = needsService.findByPage(curPage, 8, enterprise.getId());
        } else {
            pages = needsService.getPages(Needs.class, 8);
            needsList = needsService.findByPage(Needs.class, curPage, 8);
        }
        return SUCCESS;
    }

    @Action(value = "needsedit", results = {@Result(name = "success", type = "freemarker", location = "needsedit.ftl")})
    public String needsedit() {
        needs = needsService.get(Needs.class, needs.getId());
        return SUCCESS;
    }

    @Action(value = "needsupdate", results = {@Result(name = "success", type = "redirect", location = "needslist")})
    public String needsupdate() {
        Needs needs = needsService.get(Needs.class, this.needs.getId());
        needs.setTitle(this.needs.getTitle());
        needs.setContent(this.needs.getContent());
        needsService.saveOrUpdate(needs);
        return SUCCESS;
    }

    @Action(value = "needsend", results = {@Result(name = "success", type = "redirect", location = "needslist")})
    public String needsend() {
        Needs needs = needsService.get(Needs.class, this.needs.getId());
        needs.setStatus(Needs.END);
        needsService.saveOrUpdate(needs);
        return SUCCESS;
    }

    @Action(value = "needsdel", results = {@Result(name = "success", type = "redirect", location = "needslist")})
    public String needsdel() {
        needsService.delete(needs);
        return SUCCESS;
    }

    public List<Needs> getNeedsList() {
        return needsList;
    }

    public void setNeedsList(List<Needs> needsList) {
        this.needsList = needsList;
    }

    public Needs getNeeds() {
        return needs;
    }

    public void setNeeds(Needs needs) {
        this.needs = needs;
    }
}
