package com.objectiva.stream;

import cn.hutool.log.StaticLog;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * anyMatch：判断的条件里，任意一个元素成功，返回true
 *
 */
public class AnyMatchDemo {
    public static void main(String[] args) {
        // String list
        List<String> strList = Arrays.asList("Jack", "Lucy", "John", "Lily", "Willis");
        // 匹配值是Willis的字符串元素, 如果在list中能匹配到, 则返回true, 否则, 返回false
        boolean isStrMatch = strList.stream().anyMatch(str -> StringUtils.equals("Willis", str));
        StaticLog.info("isStrMatch: {}", isStrMatch); // isStrMatch: true

        // Integer list
        List<Integer> intList = Arrays.asList(1, 2, 1, 1, 3);
        boolean isIntMatch = intList.stream().anyMatch(i -> i.intValue() == 2);
        StaticLog.info("isIntMatch: {}", isIntMatch); // isIntMatch: true

        // Object list
        List<ExampleObj> objList = Arrays.asList(new ExampleObj(1, "Willis"), new ExampleObj(2, "Jackson"), new ExampleObj(3, "Linus"));
        boolean isObjMatch = objList.stream().anyMatch(obj -> null != obj && StringUtils.equals("Willis", obj.getName()) && 1 == obj.getId());
        StaticLog.info("isObjMatch: {}", isObjMatch); // isObjMatch: true

    }
}
