package com.objectiva.mockito;

import java.util.Random;

public class RandomInt {

    /**
     * 无参
     *
     * @return
     */
    public int generateRandomValue() {
        return new Random().nextInt();
    }

    /**
     * 有参
     *
     * @param bound
     * @return
     */
    public int generateRandomValue(int bound) {
        return new Random().nextInt(bound);
    }
}
