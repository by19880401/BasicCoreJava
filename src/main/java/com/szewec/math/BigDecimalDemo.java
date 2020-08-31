package com.szewec.math;

import java.math.BigDecimal;

/**
 * if the initial num is null, it will throw an exception here?
 * @author Willis.Bai
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        // if num is not null
        Integer num1 = 2;
        BigDecimal bd1 = new BigDecimal(num1);
        System.out.println("-->" + bd1.toString());// 2

        // if num is null
        Integer num2 = null;
        BigDecimal bd2 = new BigDecimal(num2);// NullPointerException
    }


}
