package com.example.lambda;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author baiyang
 * @date 2021/6/15
 */
public class ToMapDemo1 {
    private static final Integer MAX_VAL = 6;

    public static void main(String[] args) {
        List<Person> pList = initList();
        Map<String, Person> map1 = firstWayToMap(pList);
        System.out.println(map1);
        Map<String, Person> map2 = secondWayToMap(pList);
        System.out.println(map2);
    }

    /**
     * 普通方式得到map
     * @param pList
     * @return
     */
    private static Map<String, Person> firstWayToMap(List<Person> pList) {
        Map<String, Person> resultMap = new HashMap<>(MAX_VAL);
        for (Person p : pList) {
            String recordId = p.getId();
            if (StringUtils.isBlank(recordId)) {
                continue;
            }
            if (null == p.getYear() || null == p.getMonth()) {
                continue;
            }
            resultMap.put(recordId, p);
        }
        return resultMap;
    }

    /**
     *Lambda表达式方式得到map，其中Function.identity()相当于a->a,返回本身对象（自己）
     * @param pList
     * @return
     */
    private static Map<String, Person> secondWayToMap(List<Person> pList) {
        return pList.stream()
            .filter(p -> StringUtils.isNotBlank(p.getId()) && null != p.getYear() && null != p.getMonth())
            .collect(Collectors.toMap(Person::getId, Function.identity()));
    }

    private static List<Person> initList() {
        List<Person> resultList = new ArrayList<>();
        for (int i = 1; i < MAX_VAL; i++) {
            Person p = new Person();
            p.setId(String.valueOf(i));
            p.setYear(2021);
            p.setMonth(i);
            resultList.add(p);
        }
        Person p = new Person();
        p.setYear(2020);
        p.setMonth(9);
        resultList.add(p);
        return resultList;
    }
}
