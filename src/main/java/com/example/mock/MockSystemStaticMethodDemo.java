package com.example.mock;

/**
 * Mock系统类的静态和final方法
 */
public class MockSystemStaticMethodDemo {

    public String invokeSystemStaticMethod(String str) {
        return System.getProperty(str);
    }
}
