package com.zhc.core.vo;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Setting extends BaseEntity {

    @Expose
    private List<String> imageList;

    @Expose
    private String aboutContent;

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public String getAboutContent() {
        return aboutContent;
    }

    public void setAboutContent(String aboutContent) {
        this.aboutContent = aboutContent;
    }

}
