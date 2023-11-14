package com.objectiva.string;

import cn.hutool.log.StaticLog;
import org.apache.commons.lang3.StringUtils;

public class EqualsDemo {
    public static void main(String[] args) {
        boolean matched=false;
        String orgNodeId = "1";
        Long inputId = 1L;
        matched = StringUtils.equals(String.valueOf(inputId),orgNodeId);
        StaticLog.info("{}",matched);
    }
}
