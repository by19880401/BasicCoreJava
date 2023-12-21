package com.objectiva.LocalDateTime;

import cn.hutool.log.StaticLog;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetCurrentTime {
    public static void main(String[] args) {
        // this method is used by JDK8 new feature
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String currentDate = dtf.format(LocalDateTime.now());
        StaticLog.info("current time is: {}", currentDate);
    }
}
