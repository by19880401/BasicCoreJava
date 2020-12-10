package com.szewec.designpartten.command;

/**
 * Request类
 */
public class Stock {
    private String name;
    private int quantity;

    public void buy() {
        System.out.println("Stock:[name:" + name + "], qty:[" + quantity + "] buy");
    }

    public void sell() {
        System.out.println("Stock:[name:" + name + "], qty:[" + quantity + "] sell");
    }
}
