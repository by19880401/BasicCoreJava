package com.example.string;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Quarter;
import cn.hutool.log.StaticLog;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 从后向前截取，返回截取字符串后边的部分
 * @author baiyang
 * @date 2021/6/22
 */
public class SubStringDemo {
    public static void main(String[] args) {
        String fileName = "施工合同段12021年03月实际进度.xlsx";
        String suffix = StringUtils.substringAfterLast(fileName, ".");
        System.out.println(suffix);


        // 切割日期
        String quarterStr = new SimpleDateFormat("yyyy-MM").format(new Date());
        // 第一种
        String firstStr = quarterStr.substring(quarterStr.length()-2);
        StaticLog.info("--first-->{}",firstStr);
        String secondStr = StringUtils.substringAfterLast(quarterStr,"-");
        StaticLog.info("--second-->{}",secondStr);

        String quarter = DateUtil.yearAndQuarter(new Date());
        int quarterInt = DateUtil.quarter(DateUtil.parse("2021-10-03 12:12:12"));//1
        Quarter a = DateUtil.quarterEnum(DateUtil.parse("2021-10-03 12:12:12"));//Q1
        StaticLog.info("quarter:{}---{}",quarter,a);

        // 这个方法返回的month是从0开始，所以后面要+1
        int month = DateUtil.month(DateUtil.parse("2021-01-03 12:12:12"))+ 1;//10
        StaticLog.info("month:{}",month);



    }
}
