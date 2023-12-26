package com.objectiva.projectdemo.exceptions;

import cn.hutool.log.StaticLog;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String filterBy = ",";
        checkProcessBasedOnPositionAssignment(filterBy);
    }


    private static void checkProcessBasedOnPositionAssignment(String filterBy) {
        if (StringUtils.isEmpty(filterBy)) {
            StaticLog.info("set filter....");
            return;
        }
        String[] filterByArr = StringUtils.split(filterBy, ",");
        if (ArrayUtils.isEmpty(filterByArr)) {
            StaticLog.info("set filter....");
            return;
        }

        if(filterByArr.length>1){
            StaticLog.info("PE-004119, more than one values");
            return;
        }

        boolean anyMatch = Arrays.stream(ProcessBasedOnFilter.values()).anyMatch(item -> item.name().equalsIgnoreCase(filterBy));
        if (!anyMatch) {
            StaticLog.info("PE-004118");
            return;
        }
    }
}
