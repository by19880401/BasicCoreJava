package com.objectiva.array;

import cn.hutool.log.StaticLog;
import org.apache.commons.lang3.StringUtils;

public class ArrayNullDemo {
    public static void main(String[] args) {
        String str= ",";
//        String[] strArr = StringUtils.split(str,",");
        String [] strArr = str.split(",");
        StaticLog.info("{}",strArr.length>1);
    }
}
