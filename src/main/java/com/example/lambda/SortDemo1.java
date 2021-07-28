package com.example.lambda;

import cn.hutool.log.StaticLog;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 如果某属性是数据，最好用数字型字段类型，不要用字符串，字符串不好排序，容易出现1,10,2,3,4,5。。。等问题
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/7/28
 * @
 */
public class SortDemo1 {
    private static final Integer MAX_VAL = 10;
    public static void main(String [] args){
        List<Person> pList = initList();
        pList.stream().forEach(p-> StaticLog.info("-->{}",p));

        /**字符串比较*/
//        pList.sort(Comparator.comparing(Person::getId));
        /**数字型比较*/
        pList.sort(Comparator.comparingInt(Person::getMonth));

        pList.stream().forEach(p->StaticLog.info("**-->{}",p));
    }

    private static List<Person> initList() {
        List<Person> resultList = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
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
