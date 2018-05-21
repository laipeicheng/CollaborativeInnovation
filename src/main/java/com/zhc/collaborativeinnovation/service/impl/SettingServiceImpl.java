package com.zhc.collaborativeinnovation.service.impl;

import com.zhc.collaborativeinnovation.service.SettingService;
import com.zhc.core.util.SettingUtil;
import com.zhc.core.vo.Setting;
import org.springframework.stereotype.Service;

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
}
