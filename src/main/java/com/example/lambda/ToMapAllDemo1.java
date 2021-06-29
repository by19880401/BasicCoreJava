package com.example.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author baiyang
 * @date 2021/6/28
 */
public class ToMapAllDemo1 {
    private static final Integer MAX_VAL = 6;

    public static void main(String [] args){
        List<Person> pList = initList();
        /** list to map */
        Map<String, Person> resultMap = pList.stream().collect(Collectors.toMap(Person::getId, Function.identity()));
        /** 遍历map */
        resultMap.forEach((k, v) -> System.out.println("key:" + k + ", value:" + v));
        /** map to list */
        List<Person> list = resultMap.entrySet().stream().map(e -> new Person(e.getKey(), e.getValue().getName())).collect(Collectors.toList());
        /** 遍历list */
        list.stream().forEach(p -> System.out.println(p));
    }

    /**
     * Person{id='1', name='null', year=2021, month=1, planStart=null, planEnd=null}
     * Person{id='2', name='null', year=2021, month=2, planStart=null, planEnd=null}
     * Person{id='3', name='null', year=2021, month=3, planStart=null, planEnd=null}
     * Person{id='4', name='null', year=2021, month=4, planStart=null, planEnd=null}
     * Person{id='5', name='null', year=2021, month=5, planStart=null, planEnd=null}
     * @return
     */
    private static List<Person> initList() {
        List<Person> resultList = new ArrayList<>();
        for (int i = 1; i < MAX_VAL; i++) {
            Person p = new Person();
            p.setId(String.valueOf(i));
            p.setYear(2021);
            p.setMonth(i);
            p.setName("willis-" + i);
            resultList.add(p);
        }
        return resultList;
    }
}
