package com.szewec.commons.string;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

public class SplitBeforeDemo {
    public static void main(String[] args) {
        String str0 = "1,2,3,4,5,";//1,2,3,4,5
        String str1 = "1,2,3,4,5,,,,";//1,2,3,4,5
        String str2 = "1,2,3,,,4,5,,,,";//1,2,3,4,5

//        String result = StringUtils.substringBeforeLast(str2, ",");
//        System.out.println(handleStr(result,","));

        System.out.println(anotherWayToHandleStr(str1,","));
    }

    /**
     * 对于上述CASE1和CASE2的情况，也就是字符串后面有N多个分割符（逗号）的情况，可以使用下面方法先分割字符串，然后删除分割符的方法
     * @param str
     * @param splitStr
     * @return
     */
    public static String handleStr(String str, String splitStr) {
        if (StringUtils.isBlank(str)) {
            return "";
        }

        String[] strArr = StringUtils.split(str, splitStr);
        if (ArrayUtils.isEmpty(strArr)) {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        for (String s : strArr) {
            sb.append(s).append(splitStr);
        }
        return StringUtils.substringBeforeLast(sb.toString(), splitStr);
    }

    /**
     *
     * @param str is 1,2,3,4,5,,,,
     * @param splitStr
     * @return
     */
    public static String anotherWayToHandleStr(String str, String splitStr) {
        if (StringUtils.isBlank(str)) {
            return "";
        }

        if (StringUtils.endsWith(str, splitStr)) {
            str = StringUtils.substringBeforeLast(str, splitStr);
            str = anotherWayToHandleStr(str, splitStr);
        }

        return str;
    }


}
