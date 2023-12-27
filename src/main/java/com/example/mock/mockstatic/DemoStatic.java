package com.example.mock.mockstatic;

import java.util.Random;

public class DemoStatic {
    private static final Random random = new Random();

    /**
     * 使用单元测试，试一下
     *
     * @param bound
     * @return
     */
    public static int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
