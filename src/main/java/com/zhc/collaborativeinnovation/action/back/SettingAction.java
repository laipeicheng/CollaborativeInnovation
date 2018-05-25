package com.zhc.collaborativeinnovation.action.back;

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

import java.util.ArrayList;
import java.util.List;

@Namespace("/setting")
@ParentPackage("struts-default")
@Controller
public class SettingAction extends BaseAction {

    @Autowired
    @Qualifier("settingService")
    private SettingService settingService;

    private String aboutContent;

    private String[] images;

    private List<String> imageList;

    @Action(value = "updateAbout", results = {@Result(name = "success", type = "redirect", location = "about")})
    public String updateAbout() {
        log.info("updateAbout");
        settingService.saveAboutContent(aboutContent);
        return SUCCESS;
    }

    @Action(value = "about", results = {@Result(name = "success", type = "freemarker", location = "about.ftl")})
    public String about() {
        log.info("about");
        aboutContent = settingService.loadAboutContent();
        return SUCCESS;
    }

    @Action(value = "images", results = {@Result(name = "success", type = "freemarker", location = "images.ftl")})
    public String images() {
        log.info("images");
        imageList = settingService.loadImageList();
        return SUCCESS;
    }

    @Action(value = "updateimages", results = {@Result(name = "success", type = "redirect", location = "images")})
    public String updateimages() {
        log.info("updateImages");
        settingService.saveImageList(images);
        return SUCCESS;
    }

    public String getAboutContent() {
        return aboutContent;
    }

    public void setAboutContent(String aboutContent) {
        this.aboutContent = aboutContent;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }
}
