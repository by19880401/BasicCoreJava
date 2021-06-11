package com.example.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qianyy
 * @date 2021/6/11
 */
public class LMDemo {

    public static void main(String[] args) {
        List<Person> pList = initList();
        List<String> list = pList.stream().map((p -> p.getYear() + "-" + p.getMonth())).collect(Collectors.toList());
        System.out.println(list);

    }

    private static List<Person> initList() {
        List<Person> pList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Person p = new Person();
            p.setYear(2021);
            p.setMonth(i);
            pList.add(p);
        }
        return pList;
    }

}
