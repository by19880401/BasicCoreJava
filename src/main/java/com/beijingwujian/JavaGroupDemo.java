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
         *
         * 我他妈的，再也不撒谎了，真的太愧疚、太难受了
         * 感觉特别对不起媳妇的信任
         * 啥时候才能不满嘴跑火车
         * 妈的
         * 自作自受
         * 难受之极
         * 媳妇开始怀疑我了
         * 希望这次可以饶过我
         * 不要再整我
         * 我知错了
         * 不想再有下次
         * 也不想再过这样的日子
         * 明年也不想跑马拉松了
         * 觉得没有意义
         * 花钱不说
         * 还真他妈的累
         * 平时出门跑跑步就行
         * 何必非要参加不切实际的马拉松赛呢
         * 真没必要
         * 搞得自己还很被动
         * 不想再这样
         * 不想再这样
         * 不想再这样
         * 希望这次能饶过我
         * 下次不敢发！
         */

    }
}
