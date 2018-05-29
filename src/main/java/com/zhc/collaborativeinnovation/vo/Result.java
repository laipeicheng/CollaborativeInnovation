package com.zhc.collaborativeinnovation.vo;

import com.google.gson.annotations.Expose;
import com.zhc.core.vo.BaseEntity;

import java.sql.Timestamp;

public class Result extends BaseEntity {

    @Expose
    private String url;

    @Expose
    private String title;

    @Expose
    private String summary;

    @Expose
    private Timestamp publishtime;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Timestamp getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Timestamp publishtime) {
        this.publishtime = publishtime;
    }
}
