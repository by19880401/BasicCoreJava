package com.objectiva.mockito;

import cn.hutool.log.StaticLog;

public class Person {

    /**
     * 根据输入的类型判断是人的性别
     *
     * @param type
     */
    public void getSex(int type) {
        if (type == 0) {
            StaticLog.info("type是{}, 女的", type);
        } else if (type == 1) {
            StaticLog.info("type是{}, 男的", type);
        } else {
            StaticLog.info("类型错误!");
        }
    }

    /**
     * 根据输入的类型判断是人的性别
     *
     * @param type
     * @return
     */
    public String getSexAsString(int type) {
        if (type == 0) {
            StaticLog.info("type是{}, 女的", type);
            return "Female";
        } else if (type == 1) {
            StaticLog.info("type是{}, 男的", type);
            return "Male";
        } else {
            StaticLog.info("类型错误!");
            return "Null";
        }
    }

    /**
     * 根据输入的类型判断是否为男性
     *
     * @param type
     * @return
     */
    public boolean isMan(int type) {
        return type == 1;
    }

}
