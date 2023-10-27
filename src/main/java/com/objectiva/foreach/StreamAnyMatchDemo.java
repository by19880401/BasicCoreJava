package com.objectiva.foreach;

import cn.hutool.log.StaticLog;

import java.util.ArrayList;
import java.util.List;

public class StreamAnyMatchDemo {

    /**
     * 功能等效于foreach.ClassicalForeachDemo.hasAvailableBgpJobs(List<Integer> records) {...}的代码
     *
     * @param records
     * @return
     */
    public boolean hasAvailableBgpJobs(List<Integer> records) {
        return records.stream().anyMatch(record -> null != record && record.intValue() > 0);
    }

    public static void main(String[] args) {
        ClassicalForeachDemo classicalForeachDemo = new ClassicalForeachDemo();
        List<Integer> list = getList();
        StaticLog.info("list:{}", list);
        boolean hasRecords = classicalForeachDemo.hasAvailableBgpJobs(list);
        StaticLog.info("hasRecords: {}", hasRecords);
        /**
         * case1: list: [0, 0]-->hasRecords:false
         * case2: list: [0, 1]-->hasRecords:true
         * case3: list: [1, 0]-->hasRecords:true
         * case4: list: [1, 1]-->hasRecords:true
         *
         * 结论: list中只要有一个为1 则返回值为true
         */
    }

    public static List<Integer> getList() {
        List<Integer> records = new ArrayList<>();
        records.add(0);
        records.add(0);
        return records;
    }
}
