package com.example.string;

import org.apache.commons.lang.StringUtils;

/**
 * @author baiyang
 * @date 2021/6/15
 */
public class LeftPadDemo {
    /**
     * 在规定位数的字符串左侧加0
     * 输入2019-9
     * 输出：2019-09
     * @param args
     */
    public static void main(String[] args) {
        String str1 = "2019" + "-" + StringUtils.leftPad("2", 2, "0");
        String str2 = "2019" + "-" + StringUtils.leftPad("12", 2, "0");
        System.out.println(str1);
        System.out.println(str2);
    }
}
