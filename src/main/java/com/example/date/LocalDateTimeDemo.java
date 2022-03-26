package com.example.date;

import cn.hutool.log.StaticLog;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        StaticLog.info("Current Local Date Time, now the time is [{}]", ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        // reduce 6 hours
        LocalDateTime ldtPerReduce6hours = ldt.minusHours(6);
        StaticLog.info("After reduce 6 hours, now the time is [{}]", ldtPerReduce6hours.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        // plus 6 hours
        LocalDateTime ldtPerAdd6Hours = ldt.plusHours(6);
        StaticLog.info("After add 6 hours, now the time is [{}]", ldtPerAdd6Hours.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        // plus 1 minute
        LocalDateTime ldtPerAddOneMin = ldt.plusMinutes(1);
        StaticLog.info("After add 1 minute, now the time is [{}]", ldtPerAddOneMin.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

    }
}
