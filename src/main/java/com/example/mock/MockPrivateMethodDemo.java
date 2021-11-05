package com.example.mock;

/**
 * Mock 私有方法
 */
public class MockPrivateMethodDemo {

    public boolean invokePrivateMethod() {
        return isAlive();
    }

    private boolean isAlive() {
        return false;
    }
}
