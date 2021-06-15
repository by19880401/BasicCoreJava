package com.example.lambda;

import com.szewec.schedule.MainClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author baiyang
 * @date 2021/6/15
 */
public class ToMapDemo2 {

    public static void main(String[] args) {
        List<Person> pList = initList();
        Map<String, List<String>> map1 = firstWayToMap(pList);
        System.out.println(map1);
        Map<String, List<String>> map2 = secondWayToMap(pList);
        System.out.println(map2);
    }

    /**
     * 普通方式得到map
     * @param pList
     * @return
     */
    private static Map<String, List<String>> firstWayToMap(List<Person> pList) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for (Person p : pList) {
            String itemId = p.getId();
            List<String> monthList = MainClient.getMonthBetween(p.getPlanStart(), p.getPlanEnd());
            resultMap.put(itemId, monthList);
        }
        return resultMap;
    }

    /**
     * Lambda表达式方式得到map，注意在Lambda式中，是可以有方法的调用的
     * @param pList
     * @return
     */
    private static Map<String, List<String>> secondWayToMap(List<Person> pList) {
        return pList.stream().collect(Collectors.toMap(Person::getId,
            model -> MainClient.getMonthBetween(model.getPlanStart(), model.getPlanEnd())));
    }

    private static List<Person> initList() {
        List<Person> resultList = new ArrayList<>();
        Person p1 = new Person();
        p1.setId("1");
        p1.setYear(2021);
        p1.setMonth(11);
        p1.setPlanStart(MainClient.strToDateLong("2021-01-01 00:00:00"));
        p1.setPlanEnd(MainClient.strToDateLong("2021-02-25 23:59:59"));
        resultList.add(p1);
        Person p2 = new Person();
        p2.setId("2");
        p2.setYear(2021);
        p2.setMonth(12);
        p2.setPlanStart(MainClient.strToDateLong("2021-03-01 00:00:00"));
        p2.setPlanEnd(MainClient.strToDateLong("2021-06-15 23:59:59"));
        resultList.add(p2);
        return resultList;
    }
}
