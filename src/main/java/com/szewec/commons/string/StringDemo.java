package com.szewec.commons.string;

import org.apache.commons.lang.StringUtils;

public class StringDemo {
    public static void main(String[] args) {
        String str1 = "01";
        String str2 = "02";
        String str3 = "";
        String str4 = null;
        System.out.println(StringUtils.equals(str1, str2));// false
        System.out.println(StringUtils.equals(str3, str4));// false


        /**
         * 另外一个CASE
         * 当Integer为null，toString会报错吗？
         */

        Integer i = new Integer(9);
        System.out.println(i.toString());// 9

        Integer j = null;
        System.out.println(j.toString());// Exception in thread "main" java.lang.NullPointerException

    }
}
