package com.zhc.core.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.zhc.core.vo.Setting;
import org.apache.struts2.ServletActionContext;

import java.io.*;

public class SettingUtil {

    private static Gson gson = GsonUtil.getGson();

    public static void writeToJson(Setting setting) {
        try {
            String dir = ServletActionContext.getServletContext().getRealPath("/WEB-INF");
            File file = new File(dir + "/setting.json");
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStream outputStream = new FileOutputStream(file);
            JsonWriter writer = new JsonWriter(new OutputStreamWriter(outputStream, "UTF-8"));//设置编码
            gson.toJson(setting, new TypeToken<Setting>() {
            }.getType(), writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Setting readFromJson() {
        String dir = ServletActionContext.getServletContext().getRealPath("/WEB-INF");
        try {
            File file = new File(dir + "/setting.json");
            InputStream inputStream = new FileInputStream(file);
            JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
            Setting setting = gson.fromJson(reader, new TypeToken<Setting>() {
            }.getType());
            reader.close();
            return setting;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
