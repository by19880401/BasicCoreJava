package com.objectiva.format;

import cn.hutool.log.StaticLog;

public class StringFormatDemo {

    public static final String CONTENT = "%d*%s";

    public static void main(String[] args) {
        String str = String.format(CONTENT,123L,"2022-04-13");
        StaticLog.info(str);
    }
}
