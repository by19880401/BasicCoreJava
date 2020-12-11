package com.szewec.designpartten.command;

public class Main {
    public static void main(String [] args){
        // 有一个请求: 买、卖操作
        Stock stock = new Stock();
        // Order命令接口的实现:execute里执行买、卖
        BuyStock buys = new BuyStock(stock);
        SellStock sells = new SellStock(stock);
        // 创建调用类Broker: 调用操作
        Broker broker = new Broker();
        // 调用买操作
        broker.takeOrder(buys);
        // 调用卖操作
        broker.takeOrder(sells);

        int len = broker.getLength();
        System.out.println("len:" + len);

        broker.placeOrder();

    }
}
