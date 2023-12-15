package com.beijingwujian;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * lambda分组的便利性
 */
public class JavaGroupDemo {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        //当前测试以id来分组，User实体类中成员变量有id及name，全参构造方法，toString方法
        list.add(new User("1", "1"));
        list.add(new User("1", "2"));
        list.add(new User("2", "2"));
        list.add(new User("2", "3"));
        list.add(new User("2", "4"));
        list.add(new User("3", "3"));


        // 分组
        Map<String, List<User>> groupMap = list.stream().collect(Collectors.groupingBy(User::getId));


        Set<Map.Entry<String, List<User>>> entries = groupMap.entrySet();
        for(Map.Entry m : entries){
            System.out.println(m);
        }

        /**
         * Result as below:啥也不是
         *
         * 1=[User(id=1, name=1), User(id=1, name=2)]
         * 2=[User(id=2, name=2), User(id=2, name=3), User(id=2, name=4)]
         * 3=[User(id=3, name=3)]
         */

    }
}
