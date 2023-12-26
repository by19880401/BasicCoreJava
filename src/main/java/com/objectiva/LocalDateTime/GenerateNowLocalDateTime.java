package com.objectiva.LocalDateTime;

import cn.hutool.log.StaticLog;

import java.time.LocalDateTime;
import java.time.Month;

public class GenerateNowLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime ldtNow = LocalDateTime.of(2022, Month.MAY, 27, 11, 12, 14);
        StaticLog.info("Current Date Time: {}, 减少6小时之后的时间: {}", ldtNow, ldtNow.minusHours(6L));
    }
}
