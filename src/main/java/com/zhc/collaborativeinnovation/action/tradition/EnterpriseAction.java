package com.zhc.collaborativeinnovation.action.tradition;

import com.zhc.core.action.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

@Namespace("/enterprise")
@ParentPackage("struts-default")
@Controller
public class EnterpriseAction extends BaseAction {

    private String fileUrl;

    @Action(value = "auth",results = {@Result(name = "success",type = "freemarker",location = "authentication.ftl")})
    public String authentication(){
        System.out.println(fileUrl);
        return SUCCESS;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
