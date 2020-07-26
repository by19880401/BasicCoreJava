package com.szewec.lambda;

import java.util.HashMap;
import java.util.Map;

public class MapForEachDemo {
    public static void main(String[] args) {
        oldWay();
        System.out.println("*********************************");
        newWay();
    }

    // initializing the map, and put some elements
    public static Map<String, Integer> initMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);
        map.put("D", 40);
        map.put("E", 50);
        return map;
    }

    // before JDK8, the old way to loop the map
    public static void oldWay() {
        Map<String, Integer> items = initMap();
        // loop the map and output all the elements
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("key:" + entry.getKey() + "--value:" + entry.getValue());
        }

        // loop the map and output the special element
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String key = entry.getKey();
            Integer val = entry.getValue();
            // key
            if ("E".equals(key)) {
                System.out.println("-->key: " + key + " value: " + val.toString());
            }
            // value
            if (10 == val.intValue()) {
                System.out.println("-->key: " + key + " value: " + val.toString());
            }
        }

    }

    // after JDK8, the new way to loop the map (lambda express)
    public static void newWay() {
        Map<String, Integer> items = initMap();
        // loop the map and output all the elements
        items.forEach((key, val) -> System.out.println("key: " + key + "--value: " + val));
        // loop the map and output the special element
        items.forEach((key, val) -> {
            // key
            if ("E".equals(key)) {
                System.out.println("-->key: " + key + " value: " + val.toString());
            }
            // value
            if (10 == val.intValue()) {
                System.out.println("-->key: " + key + " value: " + val.toString());
            }
        });
    }
}
