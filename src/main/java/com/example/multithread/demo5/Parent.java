package com.example.multithread.demo5;

import cn.hutool.log.StaticLog;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/9
 * @
 */
public class Parent {
    public synchronized void printInfo() {
        StaticLog.info("【父类】-线程名：{}在占用这个方法，其它线程请等待", Thread.currentThread().getName());
        try {
            StaticLog.info("【父类】-{}仍然在用.....", Thread.currentThread().getName());
            Thread.sleep(10000);
            StaticLog.info("【父类】-{}释放了这个方法，其它线程可以抢了", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            StaticLog.warn("【父类】-exception now", e);
        }
    }
}
