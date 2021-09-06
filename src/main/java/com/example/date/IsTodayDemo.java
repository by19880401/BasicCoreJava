package com.example.date;

import cn.hutool.core.date.DateUtil;
import cn.hutool.log.StaticLog;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/9/3
 * @
 */
public class IsTodayDemo {
    public static void main(String [] args){
        boolean isMonth = isSameMonth(new Date(), DateUtil.parseDate("2021-09-03"));
        StaticLog.info("->{}",isMonth);


    }



    public static boolean isSameMonth(Date d1, Date d2) {
        if(null == d1 || null == d2)
            return false;
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        return  fmt.format(d1).equals(fmt.format(d2));
    }

}
