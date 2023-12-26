package com.objectiva.helloworld;

import org.apache.commons.lang3.StringUtils;

/**
 * The first test program: Hello World
 *
 * @author Willis
 * @date 2022-04-02
 */
public class HelloWorldDemo {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // Test the third-party dependencies
        String a = "";
        System.out.println("Is Blank?" + StringUtils.isBlank(a));
    }
}
