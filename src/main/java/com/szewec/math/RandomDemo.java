package com.szewec.math;

import java.util.Random;

public class RandomDemo {

    public static void main(String[] args) {
        Random r = new Random();
        int randomNum = r.nextInt();// Result: 197448246
        System.out.println(randomNum);

        double randomDouble = r.nextDouble();// Result: 0.016749289195764572
        System.out.println(randomDouble);
    }

}
