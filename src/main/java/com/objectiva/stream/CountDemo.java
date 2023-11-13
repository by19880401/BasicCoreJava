package com.objectiva.stream;

import cn.hutool.log.StaticLog;

import java.util.Arrays;
import java.util.List;

/**
 * count方法，跟List接口中的 .size() 一样，返回的都是这个集合流的元素的长度，不同的是，流是集合的一个高级工厂，中间操作是工厂里的每一道工序，我们对这个流操作完成后，可以进行元素的数量的和
 * <p>
 * 重点: count统计的是流操作完成后符合条件的元素的个数
 */
public class CountDemo {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 1, 1, 1);
        // 统计intList中值是1的元素个数
        long count1 = intList.stream().filter(i -> i == 1).count();//4
        // 统计intList中值是2的元素个数
        long count2 = intList.stream().filter(i -> i == 2).count();//1

        StaticLog.info("count1:{}, count2:{}", count1, count2);//count1:4, count2:1

    }
}
