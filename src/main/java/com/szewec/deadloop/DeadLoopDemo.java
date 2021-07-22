package com.szewec.deadloop;

import cn.hutool.core.date.DateUtil;
import cn.hutool.log.StaticLog;
import com.google.common.collect.Lists;

import java.util.Date;
import java.util.List;


public class DeadLoopDemo {

    public static void main(String[] args) {
        List<ScheduleItemModel> itemList = initList();
        if (itemList.size() > 0) {
            itemList.stream().forEach(item -> {
                updateTime(item.getStart(), item.getEnd(), item);
            });
        }
    }

    private static void updateTime(Date start, Date end, ScheduleItemModel scheduleItemModel) {
        StaticLog.info("-->{}", scheduleItemModel.getId());
    }

    private static List<ScheduleItemModel> initList() {
        List<ScheduleItemModel> list = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            ScheduleItemModel d = new ScheduleItemModel();
            d.setId(i);
            d.setStart(DateUtil.parse("2021-07-01", "yyyy-MM-dd"));
            d.setEnd(DateUtil.parse("2021-07-22", "yyyy-MM-dd"));
            list.add(d);
        }
        return list;
    }
}
