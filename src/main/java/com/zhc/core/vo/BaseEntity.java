package com.zhc.core.vo;

import com.zhc.core.util.GsonUtil;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    /**
     * 使用gson将对象转成json字符串
     *
     * @return
     */
    @Override
    public String toString() {

        //调用toJson方法将对象转成json字符串
        return GsonUtil.getGson().toJson(this);
    }
}
