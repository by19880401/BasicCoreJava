package com.example.lambda;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author baiyang
 * @date 2021/6/30
 */
public class ToMapAllDemo4 {
    private static final Integer MAX_VAL = 6;

    public static void main(String[] args) {
        List<Person> pList = initList();
        // 打印
        pList.stream().forEach(p -> System.out.println(p));
        /** 数据封装2：普通方式，同syniverse时代码*/
        Map<String, List<Person>> pMap = Maps.newLinkedHashMap();
        for (Person p : pList) {
            String key = p.getId();
            List<Person> pfList = pMap.get(key);
            if (CollectionUtils.isEmpty(pfList)) {
                pfList = Lists.newArrayList();
                pMap.put(key, pfList);
            }
            pfList.add(p);

        }
        pMap.forEach((k, v) -> System.out.println("key:" + k + ", value:" + v));

        /**
         * Person{id='1', name='willis-1', year=2021, month=1, planStart=null, planEnd=null}
         * Person{id='2', name='willis-2', year=2021, month=2, planStart=null, planEnd=null}
         * Person{id='3', name='willis-3', year=2021, month=3, planStart=null, planEnd=null}
         * Person{id='4', name='willis-4', year=2021, month=4, planStart=null, planEnd=null}
         * Person{id='5', name='willis-5', year=2021, month=5, planStart=null, planEnd=null}
         * Person{id='2', name='Lucy&Lily', year=2020, month=6, planStart=null, planEnd=null}
         * key:1, value:[Person{id='1', name='willis-1', year=2021, month=1, planStart=null, planEnd=null}]
         * key:2, value:[Person{id='2', name='willis-2', year=2021, month=2, planStart=null, planEnd=null}, Person{id='2', name='Lucy&Lily', year=2020, month=6, planStart=null, planEnd=null}]
         * key:3, value:[Person{id='3', name='willis-3', year=2021, month=3, planStart=null, planEnd=null}]
         * key:4, value:[Person{id='4', name='willis-4', year=2021, month=4, planStart=null, planEnd=null}]
         * key:5, value:[Person{id='5', name='willis-5', year=2021, month=5, planStart=null, planEnd=null}]
         */
    }


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
        Person p0 = new Person();
        p0.setId("2");
        p0.setYear(2020);
        p0.setMonth(6);
        p0.setName("Lucy&Lily");
        resultList.add(p0);
        return resultList;
    }
}
