package com.objectiva.LocalDateTime;

import cn.hutool.log.StaticLog;

import java.time.LocalDateTime;
import java.time.Month;

public class GenerateLocalDateTime {
    public static void main(String[] args) {
        // 获取当前时间
        LocalDateTime ldtNow = LocalDateTime.now();
        StaticLog.info("Current Date Time: {}", ldtNow);

        // 设置指定的时间
        LocalDateTime specialLDT1 = LocalDateTime.of(2022, Month.APRIL, 9, 10, 00, 00);
        LocalDateTime specialLDT2 = LocalDateTime.of(2022, Month.APRIL, 10, 14, 00, 00);
        StaticLog.info("指定的Date Time, DT1: {}, DT2: {}", specialLDT1, specialLDT2);
        StaticLog.info("DT2减少6小时之后的时间: {}", specialLDT2.minusHours(6L));
    }
}
