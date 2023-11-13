package com.objectiva.stream;

import cn.hutool.log.StaticLog;

import java.util.Arrays;
import java.util.List;

/**
 * allMatch：判断条件里的元素，所有的都是，返回true
 */
public class AllMatchDemo {
    public static void main(String[] args) {
        List<Integer> intList1 = Arrays.asList(1, 2, 1, 1, 1);
        // intList里所有元素都是1? 答案是:false
        boolean allMatch1 = intList1.stream().allMatch(i -> i == 1);
        StaticLog.info("allMatch1:{}", allMatch1);//allMatch1:false

        List<Integer> intList2 = Arrays.asList(1, 1, 1, 1, 1);
        // intList里所有元素都是1? 答案是:true
        boolean allMatch2 = intList2.stream().allMatch(i -> i == 1);
        StaticLog.info("allMatch2:{}", allMatch2);//allMatch2:true
    }
}
