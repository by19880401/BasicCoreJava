package com.szewec.list;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1606380882641");
        list.add("1606380882642");
        list.add("1606380882645");
        list.add("1606380882644");
        list.add("1606380882643");
        printInfo(list);
        System.out.println("**************");
        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);//降序，如果是o1.compareTo(o2).则为升序
            }
        });

        printInfo(list);
    }


    private static void printInfo(List<String> list) {
        if (CollectionUtils.isEmpty(list)) {
            System.out.println("it's empty");
            return;
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
