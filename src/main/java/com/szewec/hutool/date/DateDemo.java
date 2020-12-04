package com.szewec.hutool.date;

import cn.hutool.core.convert.Convert;

import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        String dateStr = "2020-12-01";
        Date date = Convert.toDate(dateStr);
        System.out.println("date: " + date);//date: Tue Dec 01 00:00:00 CST 2020
    }
}
