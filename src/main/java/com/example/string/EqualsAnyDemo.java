package com.example.string;

import org.apache.commons.lang3.StringUtils;

;

/**
 * 字符串与给出的两个参考字符中任意一个匹配，返回true
 * @author baiyang
 * @date 2021/6/22
 */
public class EqualsAnyDemo {
    public static void main(String[] args) {
        String fileName = "xls";
        boolean isTrue = StringUtils.equalsAny(fileName, "xlsx", "xls");
        System.out.println(isTrue);
    }
}
