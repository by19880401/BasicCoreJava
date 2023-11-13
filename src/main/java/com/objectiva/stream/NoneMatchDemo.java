package com.objectiva.stream;

import cn.hutool.log.StaticLog;

import java.util.Arrays;
import java.util.List;

/**
 * noneMatch：与allMatch相反，判断条件里的元素，所有的都不是，返回true
 */
public class NoneMatchDemo {
    public static void main(String[] args) {
        List<Integer> intList1 = Arrays.asList(1, 2, 1, 1, 1);
        // intList1里的元素, 都不是1? false
        boolean isNoneMatch1 = intList1.stream().noneMatch(i -> i == 1);
        StaticLog.info("isNoneMatch1:{}", isNoneMatch1);// isNoneMatch1:false

        List<Integer> intList2 = Arrays.asList(3, 2, 4, 5, 6);
        // intList2里的元素, 都不是1? false
        boolean isNoneMatch2 = intList2.stream().noneMatch(i -> i == 1);
        StaticLog.info("isNoneMatch2:{}", isNoneMatch2);// isNoneMatch2:true

    }
}
