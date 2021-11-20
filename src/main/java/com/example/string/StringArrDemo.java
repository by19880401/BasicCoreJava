package com.example.string;

public class StringArrDemo {

    public static void main(String[] args) {
        String[] demo1 = new String[]{};
        System.out.println(demo1);// [Ljava.lang.String;@568db2f2
        isZero(0);

    }

    public static void isZero(Integer param){
        System.out.println(param);// 0
        System.out.println(null == param);// false
        System.out.println(param == 0);// true
    }

}
