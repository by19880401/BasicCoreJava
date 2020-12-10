package com.szewec.designpartten.command;

/**
 * Order接口的实现类，买操作
 */
public class BuyStock implements Order {
    private Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}
