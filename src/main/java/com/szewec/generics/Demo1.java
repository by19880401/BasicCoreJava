package com.szewec.generics;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * T 用法
 *
 * 类名Demo1<T>是必须要加的，否则会报"cannot resolve symbol 'T'"
 * 返回值，直接写T表示限制参数的类型，这种方法一般多用于共同操作一个类对象，然后获取里面的集合信息啥的
 * @param <T>, 泛型，指限制参数类型为T
 */
public class Demo1<T> {
    public static void main(String[] args) {
        //限制T 为String 类型
        Demo1<String> demoStr = new Demo1<>();
        List<String> list = new ArrayList<String>();
        list.add("ele-1");
        list.add("ele-2");
        String str = demoStr.getListFirst(list);
        System.out.println(str);

        //获取Integer类型, T为Integer类型
        Demo1<Integer> demoInt = new Demo1<>();
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(12);
        intList.add(13);
        Integer i = demoInt.getListFirst(intList);
        System.out.println(i);
    }

    /**
     * 这个只能传递T类型的数据
     *返回值 就是Demo1<T> 实例化传递的对象类型
     *
     *返回list中的第一个元素
     * @param list, 传入参数为T类型的list
     * @return, 返回T类型的对象
     */
    private T getListFirst(List<T> list) {//不能把这方法写成静态的，不知原因
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }
}
