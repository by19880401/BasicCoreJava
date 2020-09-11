package com.szewec.math;

import java.math.BigDecimal;

public class AddDemo {

    /**
     * 两个数值相加，循环相加
     * @param args
     */
    public static void main(String[] args) {
        BigDecimal init = new BigDecimal("0");
        for (int i = 1; i < 4; i++) {
            BigDecimal bd = new BigDecimal(i);
            init.add(bd); // 错误
            init = init.add(bd); // 正确
        }

        System.out.println(init.toString());
    }
}
