package com.zhc.collaborativeinnovation.action.ajax;

import com.zhc.collaborativeinnovation.service.WebsiteService;
import com.zhc.collaborativeinnovation.vo.Website;
import com.zhc.core.action.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Namespace("/favorite")
@ParentPackage("json-default")
@Controller("ajaxFavorite")
public class FavoriteAction extends BaseAction {

    @Autowired
    @Qualifier("websiteService")
    private WebsiteService websiteService;

    private Website website;

    private int websiteid;

    @Action(value = "loadWebsite", results = {@Result(type = "json")})
    public String loadWebsite(){
        log.info("loadWebsite-websiteid:{}", websiteid);
        website = websiteService.get(Website.class, websiteid);
        return SUCCESS;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }

    public int getWebsiteid() {
        return websiteid;
    }

    public void setWebsiteid(int websiteid) {
        this.websiteid = websiteid;
    }
}
