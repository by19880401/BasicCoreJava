package com.example.obj;

import cn.hutool.log.StaticLog;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/7/22
 * @
 */
public class ObjectDemo {
    public static void main(String[] args) {
        Fish f = testCase3();
        StaticLog.info("print info: {}, is null-->{}", f, isObjAllFieldsNull(f));
    }

    public static Fish testCase1() {
        return new Fish();
    }

    public static Fish testCase2() {
        Fish f = new Fish();
        f.setId(1);
        f.setName("willis");
        f.setAddress("GaoXinHuaFu.XiFen.3Road");
        return f;
    }

    public static Fish testCase3() {
        Fish f = new Fish();
        f.setId(null);
        f.setName(null);
        f.setAddress(null);
        return f;
    }


    /**
     * 判断对象中的所有属性是否都为null
     *
     * @param object
     * @return
     */
    public static boolean isObjAllFieldsNull(Object object) {
        if (null == object) {
            return true;
        }
        try {
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.get(object) != null && StringUtils.isNotBlank(f.get(object).toString())) {
                    return false;
                }
            }
        } catch (Exception e) {
            StaticLog.warn("有异常：{}", e);
        }
        return true;
    }
}
