package com.example.parse;

import cn.hutool.log.StaticLog;

import java.math.BigDecimal;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/7/28
 * @
 */
public class ParseObjDemo {
    public static void main(String[] args) {
//        Double d = 1.50;
        Double d = null;
        String resultStr = parseObj(d);
        StaticLog.info("-->{}", resultStr);

        new BigDecimal(resultStr);

    }

    public static String parseObj(Object obj) {
        if (obj instanceof Double) {
            Double d = (Double) obj;
            return (null == d ? "0" : String.valueOf(d));
        } else {
            return "0";
        }
    }
}
