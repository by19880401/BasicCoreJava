package com.objectiva.mockstatic;

import java.util.Random;

public class DemoStatic {

    private static final Random random = new Random();

    public static String sayHello() {
        return "Hello";
    }

    public static String saySomething(String word) {
        return word;
    }

    public static void sayAgain() {
        System.out.println(getMyWord());
    }

    private static String getMyWord() {
        return "This is my word";
    }

    /**
     * 使用单元测试, 试一下
     *
     * @param bound
     * @return
     */
    public static int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
