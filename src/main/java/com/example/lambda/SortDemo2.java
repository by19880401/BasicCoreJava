package com.example.lambda;

import cn.hutool.log.StaticLog;

import java.util.Arrays;
import java.util.List;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/7/28
 * @
 */
public class SortDemo2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 5, 7, 8, 10, 30, 20, 100, 90);
        StaticLog.info("-->{}", list);

        // 升序
        list.sort((a, b) -> a.compareTo(b.intValue()));
        StaticLog.info("**-->{}", list);

        // 降序
        list.sort((a,b)->b.compareTo(a.intValue()));
        StaticLog.info("%%-->{}", list);

    }
}
