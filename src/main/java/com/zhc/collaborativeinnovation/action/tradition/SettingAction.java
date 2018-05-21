package com.zhc.collaborativeinnovation.action.tradition;

import com.zhc.collaborativeinnovation.service.SettingService;
import com.zhc.core.action.BaseAction;
import com.zhc.core.vo.Setting;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Namespace("/setting")
@ParentPackage("struts-default")
@Controller
public class SettingAction extends BaseAction {

    @Autowired
    @Qualifier("settingService")
    private SettingService settingService;

    private String aboutContent;

    @Action(value = "updateAbout",results = {@Result(name = "success", type = "redirect",location = "about")})
    public String updateAbout(){
        Setting setting = settingService.getSetting();
        setting.setAboutContent(aboutContent);
        settingService.saveSetting(setting);
        return SUCCESS;
    }

    @Action(value = "about",results = {@Result(name = "success", type = "freemarker",location = "about.ftl")})
    public String about(){
        aboutContent = settingService.getSetting().getAboutContent();
        return SUCCESS;
    }

    public String getAboutContent() {
        return aboutContent;
    }

    public void setAboutContent(String aboutContent) {
        this.aboutContent = aboutContent;
    }
}
