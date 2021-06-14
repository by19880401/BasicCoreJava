package com.szewec.schedule;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author baiyang
 * @date 2021/6/11
 */
public class MainClient {
    public static void main(String [] args){
        Date start = strToDateLong("2022-08-19 00:00:00");
        Date end = strToDateLong("2022-08-31 23:59:59");
//        List<String> list = getMonths(start,end);
        List<String> list = getMonthBetween(start,end);
        System.out.println(list);
    }


    /**
     * 获取两个时间节点之间的月份列表
     * CASE1:
     * 输入：2022-08-19 00:00:00和2022-08-31 23:59:59
     * 输出：[2022-08]
     * CASE2:
     * 输入：2021-08-19 00:00:00和2022-08-31 23:59:59
     * 输出：[2021-08, 2021-09, 2021-10, 2021-11, 2021-12, 2022-01, 2022-02, 2022-03, 2022-04, 2022-05, 2022-06, 2022-07, 2022-08]
     * @param minDate
     * @param maxDate
     * @return
     */
    private static List<String> getMonthBetween(Date minDate, Date maxDate){
        List<String> result = new ArrayList<String>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

            Calendar min = Calendar.getInstance();
            Calendar max = Calendar.getInstance();
            min.setTime(minDate);
            min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

            max.setTime(maxDate);
            max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

            Calendar curr = min;
            while (curr.before(max)) {
                result.add(sdf.format(curr.getTime()));
                curr.add(Calendar.MONTH, 1);
            }

        return result;
    }

    /**
     * [2019-05, 2019-06, 2019-07, 2019-08, 2019-09, 2019-10, 2019-11, 2019-12, 2020-01]
     * [2019-05, 2019-06, 2019-07, 2019-08, 2019-09, 2019-10, 2019-11, 2019-12, 2020-01]
     *
     * 此方法在以下场景时输出结果不正确
     * 输入：2022-08-19 00:00:00和2022-08-31 23:59:59
     * 输出：[2022-08, 2022-09]
     * 预期输出：[2022-08]
     *
     * @param
     * @param
     * @return
     */
    @Deprecated
    public static List<String> getMonths(Date start, Date end){
        List<String> res=new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        try {
            Calendar tempStart = Calendar.getInstance();
            Calendar tempEnd = Calendar.getInstance();
            tempStart.setTime(start);
            tempEnd.setTime(end);
            tempEnd.add(Calendar.MONTH,1);
            while (tempStart.before(tempEnd)) {
                String month=dateFormat.format(tempStart.getTime());
                tempStart.set(Calendar.DAY_OF_MONTH, 1);
                tempStart.set(Calendar.DAY_OF_MONTH, tempStart.getActualMaximum(Calendar.DAY_OF_MONTH));
                res.add(month);
                tempStart.add(Calendar.MONTH,1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 此方法也存在输出结果不正确的场景，同上
     * @param startTime
     * @param endTime
     * @return
     */
    @Deprecated
    public static List<Map> getMonthsDetails(String startTime, String endTime){
        List<Map> res=new ArrayList<Map>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = dateFormat.parse(startTime);
            Date end = dateFormat.parse(endTime);
            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);
            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            tempEnd.add(Calendar.MONTH,1);// 日期加1(包含结束)
            while (tempStart.before(tempEnd)) {
                String month=dateFormat.format(tempStart.getTime());
                tempStart.set(Calendar.DAY_OF_MONTH, 1);
                String first=dateFormat3.format(tempStart.getTime());
                tempStart.set(Calendar.DAY_OF_MONTH, tempStart.getActualMaximum(Calendar.DAY_OF_MONTH));
                Map<String,Object> map=new HashMap<String,Object>();
                map.put("month", month);
                map.put("first", dateFormat2.parse(first+" 00:00:00"));
                map.put("last", dateFormat2.parse(first+" 23:59:59"));
                res.add(map);
                tempStart.add(Calendar.MONTH,1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static Date strToDateLong(String strDate) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ParsePosition pos = new ParsePosition(0);
            Date strtodate = formatter.parse(strDate, pos);
            return strtodate;
         }
}
