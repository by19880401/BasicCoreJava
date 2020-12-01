package com.szewec.map;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PutValue2Map {
    public static void main(String[] args) {
        // 初始化
        List<String> pList = getParentList();
        List<Food> cList = getChildList();
        printInfo(pList);
        printInfo(cList);
        printInfo(null, true);
        Map<String, List<Food>> map = new HashMap<>();
        for (String key : pList) {
            for (Food food : cList) {
                if (StringUtils.equals(key, food.getId())) {
                    List<Food> tempList = map.get(key);
                    if (CollectionUtils.isEmpty(tempList)) {
                        tempList = new ArrayList<>();
                        map.put(key, tempList);
                    }
                    tempList.add(food);
                }
            }
        }

        List<String> resultList = new ArrayList<>();
        for (Map.Entry<String, List<Food>> entry : map.entrySet()) {
//            System.out.println("key: " + entry.getKey() + "List:" + entry.getValue());
            if(pList.contains(entry.getKey())){
                resultList.add(entry.getKey());
            }
        }
        pList = resultList;
        printInfo(pList);
    }


    private static List<String> getParentList() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            result.add(String.valueOf(i));
        }
        return result;
    }

    private static List<Food> getChildList() {
        List<Food> result = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Food food = new Food();
            food.setId(String.valueOf(i));
            food.setName("Food-" + i);
            result.add(food);
        }
        return result;
    }

    private static void printInfo(List<?> list) {
        printInfo(list, false);
    }

    private static void printInfo(List<?> list, boolean isNeedLine) {
        if (CollectionUtils.isEmpty(list)) {
            if (isNeedLine) {
                System.out.println("*******************");
            } else {
                System.out.println("list为空");
            }
            return;
        }
        for (Object t : list) {
            if (t instanceof String) {
                String s = (String) t;
                System.out.println(s);
            } else if (t instanceof Food) {
                Food food = (Food) t;
                System.out.println(food.toString());
            }
        }
    }
}
