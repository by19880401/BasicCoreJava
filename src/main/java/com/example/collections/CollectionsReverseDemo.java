package com.example.collections;

import cn.hutool.log.StaticLog;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * 颠倒List中元素的位置顺序
 * 输入：[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * 输出：[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
 * @author baiyang
 * @date 2021/7/21
 */
public class CollectionsReverseDemo {
    public static void main(String[] args) {
        List<Integer> initList = initList();
        StaticLog.info("old list: {}", initList);
        Collections.reverse(initList);
        StaticLog.info("new list: {}", initList);

        /**
         * 结果：
         * 11:14:46.512 [main] INFO com.example.collections.CollectionsReverseDemo - old list: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
         * 11:14:46.512 [main] INFO com.example.collections.CollectionsReverseDemo - new list: [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
         */
    }

    /**
     * 初始化list
     *
     * @return
     */
    public static List<Integer> initList() {
        List<Integer> resultList = Lists.newArrayList();
        for (int i = 1; i <= 10; i++) {
            resultList.add(i);
        }
        return resultList;
    }

    /**
     * 打印list
     *
     * @param list
     */
    public static void printListInfo(List<Integer> list) {
        if (CollectionUtils.isEmpty(list)) {
            StaticLog.warn("list is empty, please check");
            return;
        }
        list.stream().forEach(l -> StaticLog.info("==>{}", l));
    }
}
