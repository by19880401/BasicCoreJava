package com.objectiva.projectdemo.switchdemo;

import cn.hutool.log.StaticLog;
import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) {
        String processBasedOnType = ProcessBasedOn.POSITION_ASSIGNMENT.name();
        switchDemo1(processBasedOnType);
    }


    public static void switchDemo1(String processBasedOnType) {
        if (ProcessBasedOn.PRIMARY.name().equals(StringUtils.upperCase(processBasedOnType))) {
            StaticLog.info("primary");
        } else if (ProcessBasedOn.WORKED.name().equals(StringUtils.upperCase(processBasedOnType))) {
            StaticLog.info("Worked");
        } else if (ProcessBasedOn.POSITION_ASSIGNMENT.name().equals(StringUtils.upperCase(processBasedOnType))) {
            StaticLog.info("position assignment");
        }
    }
}
