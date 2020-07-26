package com.szewec.lambda;

import java.util.ArrayList;
import java.util.List;

public class ListForEachDemo {
    public static void main(String[] args) {
        oldWay();
        System.out.println("*********************************");
        newWay();
    }

    // initializing a list, add some string in it
    public static List<String> initList() {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        return list;
    }

    // before JDK8, the old way to loop the list
    public static void oldWay() {
        List<String> items = initList();

        // loop the list and output all the elements
        for (String item : items) {
            System.out.println(item);
        }

        // loop the list and output the special element
        for (String item : items) {
            if ("C".equals(item)) {
                System.out.println("-->" + item);
            }
        }
    }

    // after JDK8, the new way to loop the list (lambda express)
    public static void newWay() {
        List<String> items = initList();

        // loop the list and output all the elements
        items.forEach(item -> System.out.println(item));

        // loop the list and output the special element
        items.forEach(item -> {
            if ("C".equals(item)) {
                System.out.println("-->" + item);
            }
        });
    }

}
