package com.szewec.hutool.list;

import cn.hutool.core.convert.Convert;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class ConvertListDemo {
    public static void main(String[] args) {
        Object[] array = {"a", "你好", "", 1};
        List<?> list = Convert.toList(array);
        System.out.println("list.size = " + list.size());
        print(list);
    }

    private static void print(List<?> list) {
        if (CollectionUtils.isEmpty(list)) {
            System.out.println("Empty list");
            return;
        }
        for (Object obj : list) {
            System.out.println(obj.toString());
        }
    }
}
