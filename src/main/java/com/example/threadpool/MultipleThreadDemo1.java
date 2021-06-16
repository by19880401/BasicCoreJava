package com.example.threadpool;

import java.util.concurrent.*;

/**
 * @author baiyang
 * @date 2021/6/16
 */
public class MultipleThreadDemo1 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        try {
            System.out.println("开始处理任务");
            Future<String> future = threadPool.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(10000L);
                    System.out.println("子线程执行，线程名：" + Thread.currentThread().getName());
                    return "complete";
                }
            });
            System.out.println("主线程继续执行.........线程名：" + Thread.currentThread().getName());
            System.out.println("waiting result:" + future.get());
            System.out.println("完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }


        /**
         * 开始处理任务
         * 主线程继续执行.........线程名：main
         * 子线程执行，线程名：pool-1-thread-1（10s后才打印）
         * waiting result:complete（10s后才打印）
         * 完成（10s后才打印）
         */
    }
}
