package com.zhc.collaborativeinnovation.action.stream;

import com.opensymphony.xwork2.ActionSupport;
import com.zhc.collaborativeinnovation.vo.Enterprise;
import com.zhc.core.service.BaseService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Namespace("/stream")
@ParentPackage("struts-default")
@Controller
public class StreamAction extends ActionSupport {

    private int enterpriseid;

    private InputStream inputStream;

    @Autowired
    @Qualifier("baseService")
    private BaseService<Enterprise> enterpriseService;

    /**
     * 获取营业执照，响应二进制流到客户端，客户端显示图片
     *
     * @return
     */
    @Action(value = "license", results = {@Result(type = "stream", params = {"contentType", "image/jpeg", "inputName", "inputStream"})})
    public String license() {
        Enterprise enterprise = enterpriseService.get(Enterprise.class, enterpriseid);
        inputStream = new ByteArrayInputStream(enterprise.getLicense());
        return SUCCESS;
    }

    public int getEnterpriseid() {
        return enterpriseid;
    }

    public void setEnterpriseid(int enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
