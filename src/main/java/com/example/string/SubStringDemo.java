package com.example.string;

import org.apache.commons.lang.StringUtils;

/**
 * 从后向前截取，返回截取字符串后边的部分
 * @author baiyang
 * @date 2021/6/22
 */
public class SubStringDemo {
    public static void main(String[] args) {
        String fileName = "施工合同段12021年03月实际进度.xlsx";
        String suffix = StringUtils.substringAfterLast(fileName, ".");
        System.out.println(suffix);
    }
}
