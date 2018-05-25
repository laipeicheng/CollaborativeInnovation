package com.zhc.collaborativeinnovation.service.impl;

import com.zhc.collaborativeinnovation.service.SettingService;
import com.zhc.core.util.SettingUtil;
import com.zhc.core.vo.Setting;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("settingService")
public class SettingServiceImpl implements SettingService {

    @Override
    public void saveSetting(Setting setting) {
        SettingUtil.writeToJson(setting);
    }

    @Override
    public Setting getSetting() {
        return SettingUtil.readFromJson();
    }

    @Override
    public void saveImageList(String[] images) {
        Setting setting =  getSetting();
        List<String> imageList = new ArrayList<String>();
        if (images!=null) {
            for (String image : images) {
                imageList.add(image);
            }
            setting.setImageList(imageList);
            saveSetting(setting);
        }
    }

    public void saveAboutContent(String aboutContent){
        Setting setting =  getSetting();
        setting.setAboutContent(aboutContent);
        saveSetting(setting);
    }

    @Override
    public List<String> loadImageList() {
        return getSetting().getImageList();
    }

    @Override
    public String loadAboutContent() {
        return getSetting().getAboutContent();
    }
}
