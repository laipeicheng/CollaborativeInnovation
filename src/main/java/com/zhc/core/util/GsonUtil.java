package com.zhc.core.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {

    private static Gson gson;

    public static Gson getGson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        //只将具有Expose注解的属性进行转json
        gsonBuilder = gsonBuilder.excludeFieldsWithoutExposeAnnotation();
        //将null值得属性也进行转json
        gsonBuilder = gsonBuilder.serializeNulls();
        //格式化json
        gsonBuilder = gsonBuilder.setPrettyPrinting();
        //创建gson对象
        gson = gsonBuilder.create();

        return gson;
    }
}
