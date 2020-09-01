package com.szewec.lambda.stream;

import java.util.stream.Stream;

/**
 * stream的过滤
 */
public class StringStreamFilterDemo {
    public static void main(String[] args) {
        String[] strArr = {"Apple", "Orange", "Lemon"};
        // System.out.println()有两种写法：
        Stream.of(strArr).filter(t -> !t.equals("Apple")).forEach(t -> System.out.println(t));
        // 或者：
        Stream.of(strArr).filter(t -> !t.equals("Apple")).forEach(System.out::println);
    }
}
