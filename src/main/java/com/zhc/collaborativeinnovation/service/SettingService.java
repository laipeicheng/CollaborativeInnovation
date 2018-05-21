package com.zhc.collaborativeinnovation.service;


import com.zhc.core.vo.Setting;

public interface SettingService {

    void saveSetting(Setting setting);

    Setting getSetting();
}
