package com.example.string;

/**
 * 强转时，如果被转对象为null，则不会报错
 */
public class NullString {
    public static void main(String[] args) {
        Object obj = null;
        String str = (String) obj;
        System.out.println("str:" + str);
    }
}
