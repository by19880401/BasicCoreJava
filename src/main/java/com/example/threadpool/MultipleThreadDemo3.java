package com.example.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author baiyang
 * @date 2021/6/16
 */
public class MultipleThreadDemo3 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        System.out.println("开始处理任务");
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    threadPool.shutdown();
                }
                System.out.println("子线程执行，线程名：" + Thread.currentThread().getName());
            }
        });
        System.out.println("主线程继续执行.........线程名：" + Thread.currentThread().getName());
        System.out.println("完成");

        /**
         * 开始处理任务
         * 主线程继续执行.........线程名：main
         * 完成
         * 子线程执行，线程名：pool-1-thread-1（注：10s后才打印出来）
         */

    }
}
