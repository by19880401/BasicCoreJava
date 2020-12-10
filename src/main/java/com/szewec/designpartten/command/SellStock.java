package com.szewec.designpartten.command;

/**
 * Order接口的实现类，卖操作
 */
public class SellStock implements Order {
    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}
