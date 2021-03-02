package com.example.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListDemo {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        for (int i = 0; i < 5; i++) {
            Person p = new Person();
            p.setName("willis" + i);
            p.setAge(String.valueOf(i));
            list.add(p);
        }

        list.forEach(p -> System.out.println(p.toString()));
        /**结果：
         * Person{name='willis0', age=0}
         * Person{name='willis1', age=1}
         * Person{name='willis2', age=2}
         * Person{name='willis3', age=3}
         * Person{name='willis4', age=4}
         */
        System.out.println("***********************");
        // 下面这行代码的意思：把list里person类里的name取出来，并用","连接成字符串返回
        String str1 = list.stream().map(Person::getName).collect(Collectors.joining(","));
        String str2 = list.stream().map(Person::getAge).collect(Collectors.joining("|"));
        System.out.println(str1);// 结果：willis0,willis1,willis2,willis3,willis4
        System.out.println(str2);// 结果：0|1|2|3|4
    }

}
