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
         * 下次不敢再这样了！
         *
         * 第二天（2023-12-19日）更新：
         * 虽然媳妇心里有所怀疑
         * 但好像也没有找到什么证据
         * 也不好再质疑我
         * 从目前来看
         * 这一次风波应该是平安渡过了
         * 就这样吧
         * 以后绝对不会再发生这样的事情了
         * 绝对不能再有下次
         * 明年大不了咱不跑马拉松了
         * 我觉得自己突然间顿悟了
         * 对马拉松比赛也并没有那么痴迷
         * 媳妇允许跑4场外地的比赛
         * 但我感觉有个一两场就足够了
         * 4场都有点太多了
         * 看情况吧
         * 如果实在不想“折磨”自己
         * 就参加一两场玩玩就算了
         * 真没必要场场都参加
         * 咱又不是专业选手
         * 也不是为了站台
         * 只是兴趣
         * 跑着玩而已
         * 看着自己的成绩每次都是4小时左右
         * 就觉得很搞笑
         * 就这样吧
         * 冬天也根据自己的兴趣
         * 隔天跑一次
         * 没必要搞得自己天天去参加比赛
         * 家里的钱也不够我霍霍的
         * 现在自己欠那么外债呢
         * 本以为到年底之后所有的欠款应该全部归还完成
         * 但没想到自己又欠了一大笔外债
         * 搞得自己痛苦不甚
         * 发誓：这笔外债还清之后，再也不欠外债
         * 自己舒舒服服地过着平谈的日子不香吗
         * 从此
         * 时时告诫自己：见好就收，绝对不要再试图挑战一些不合理的想法
         * 绝对不能再有下次
         * 绝对 不能
         * 绝对的
         * 记住了啊
         *
         */

    }
}
