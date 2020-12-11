package com.szewec.designpartten.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令调用类
 */
public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrder() {
        for (Order o : orderList) {
            o.execute();
        }
        orderList.clear();
    }

    public int getLength() {
        return orderList.size();
    }
}
