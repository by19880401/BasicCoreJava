package com.objectiva.LocalDateTime;

import cn.hutool.log.StaticLog;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompareLDT {
    /**
     * return the elements whose time is 2022-04-10 08:00:00 ~ 2022-04-10 14:00:00
     *
     * @param args
     */
    public static void main(String[] args) {

        LocalDateTime specialLDT1 = LocalDateTime.of(2022, Month.APRIL, 10, 7, 00, 00);
        LocalDateTime specialLDT2 = LocalDateTime.of(2022, Month.APRIL, 10, 9, 00, 00);
        LocalDateTime specialLDT3 = LocalDateTime.of(2022, Month.APRIL, 10, 13, 00, 00);

        List<LocalDateTime> ldtList = new ArrayList<>();
        ldtList.add(specialLDT1);
        ldtList.add(specialLDT2);
        ldtList.add(specialLDT3);

        LocalDateTime specialLDT = LocalDateTime.of(2022, Month.APRIL, 10, 14, 00, 00).minusHours(6L);
        List<LocalDateTime> result = ldtList.stream().filter(a -> a.isAfter(specialLDT)).collect(Collectors.toList());

        StaticLog.info("Result size: {}", result.size());//Result size: 2, there are: 2022-04-10T09:00 and 2022-04-10T13:00
        StaticLog.info("============================");

        LocalDate ld = LocalDate.now();
        StaticLog.info("Current Date: {}", ld);// Current Date: 2022-04-10
        StaticLog.info("Reduce 1 year: {}", ld.plusYears(1));// Reduce 1 year: 2023-04-10

    }
}
