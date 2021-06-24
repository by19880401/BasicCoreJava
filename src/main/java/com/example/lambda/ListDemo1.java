package com.example.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author baiyang
 * @date 2021/6/24
 */
public class ListDemo1 {
    public static void main(String[] args) {
        List<Person> list = initPersonList();
        /** 注意：下述Person::getId和user -> user.getId()是等效的两种写法 */
        // 获取person中id列表
        List<String> idList = list.stream().map(Person::getId).collect(Collectors.toList());
        // 获取person中name列表
        List<String> nameList = list.stream().map(user -> user.getName()).collect(Collectors.toList());
        // 打印
        idList.stream().forEach(n -> System.out.println(n));
        nameList.stream().forEach(n -> System.out.println(n));
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
