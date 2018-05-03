package com.zhc.core.vo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    private static Gson gson;

    static{
        GsonBuilder gsonBuilder = new GsonBuilder();
        //只将具有Exclude注解的属性进行转json
        gsonBuilder = gsonBuilder.excludeFieldsWithoutExposeAnnotation();
        //将null值得属性也进行转json
        gsonBuilder = gsonBuilder.serializeNulls();
        //格式化json
        gsonBuilder = gsonBuilder.setPrettyPrinting();
        //创建gson对象
        gson = gsonBuilder.create();
    }

    /**
     * 使用gson将对象转成json字符串
     * @return
     */
    @Override
    public String toString() {

        //调用toJson方法将对象转成json字符串
        return gson.toJson(this);
    }
}
