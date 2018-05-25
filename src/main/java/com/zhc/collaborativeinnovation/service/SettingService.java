package com.zhc.collaborativeinnovation.service;


import com.zhc.core.vo.Setting;

import java.util.List;

public interface SettingService {

    void saveSetting(Setting setting);

    Setting getSetting();

    void saveImageList(String[] images);

    void saveAboutContent(String aboutContent);

    List<String> loadImageList();

    String loadAboutContent();

}
