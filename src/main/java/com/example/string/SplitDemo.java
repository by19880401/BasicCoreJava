package com.example.string;

import cn.hutool.log.StaticLog;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/7/21
 * @
 */
public class SplitDemo {
    public static void main(String[] args) {
//        String str = "1###2###3####";
        String str = null;
//        String str = "";
//        List<String> list = Arrays.asList(str.split("###"));
        if (StringUtils.isBlank(str)) {
            StaticLog.info("str is null");
            return;
        }
        List<String> list = Arrays.asList(StringUtils.split(str, "###"));
        StaticLog.info("list: {}", list);
    }
}
