package com.szewec.generics;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <T> T 用法
 *
 * <T> T 表示的是返回值T是泛型，T是一个占位符，用来告诉编译器，这个东西先给我留着，等我编译的时候，告诉你
 */
public class Demo2 {//这次的类名没有<T>
    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        //获取string类型
        List<String> list = new ArrayList<String>();
        list.add("ele-1");
        list.add("ele-2");
        String str = demo2.getListFisrt(list);
        System.out.println(str);

        //获取nums类型
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(12);
        nums.add(13);
        Integer num = demo2.getListFisrt(nums);
        System.out.println(num);
    }

    /**
     * 这个<T> T 可以传入任何类型的List
     * @param list
     * @param <T>，表示限制参数类型为T
     * @return <T> T,第一个T表示是泛型，第二个T表示返回的是T类型的数据
     */
    private <T> T getListFisrt(List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }
}
