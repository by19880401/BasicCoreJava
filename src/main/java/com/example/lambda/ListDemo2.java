package com.example.lambda;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qianyy
 * @date 2021/6/24
 */
public class ListDemo2 {
    public static void main(String [] args){
        List<Person> list = initPersonList();
        // 获取list中名字叫willis的person
        //方法1：普通实现方式
        List<Person> resultList = new ArrayList<>();
        for(Person p:list){
            if(StringUtils.equals("willis",p.getName())){
                resultList.add(p);
            }
        }
        //方法2：lambda实现方式
        List<Person> pList = list.stream().filter(p-> StringUtils.equals("willis",p.getName())).collect(Collectors.toList());
        // 打印
        pList.stream().forEach(p-> System.out.println(p));
    }

    private static List<Person> initPersonList() {
        Person p1 = new Person("01", "willis");
        Person p2 = new Person("02", "Lucy");
        Person p3 = new Person("03", "Lily");
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        return list;
    }
}
