package com.szewec.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LongLongAgoDate {
    public static void main(String[] args) {
        Date date = getLongLongAgoDate();
        System.out.println("------------>" + date);//Fri Apr 01 00:00:00 CST 1988
        Date date2 = getLongLongAgoDate2();
        System.out.println("------------>" + date2);//Fri Apr 01 13:37:28 CST 1988
    }

    /**
     * 获取指定年月日的某一日期（返回date），如下指定1988-04-01
     * @return
     */
    public static Date getLongLongAgoDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse("1988-04-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * （推荐）获取指定年月日的某一日期（返回date），如下指定1988-04-01
     * @return
     */
    // suggest way
    // month:0 ~11表示12个月
    public static Date getLongLongAgoDate2() {
        Calendar c = Calendar.getInstance();
        c.set(1988, 3, 1);
        return c.getTime();
    }
}
