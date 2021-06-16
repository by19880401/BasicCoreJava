package com.example.threadpool;

import java.util.concurrent.*;

/**
 * @author baiyang
 * @date 2021/6/16
 */
public class MultipleThreadDemo1 {
    public static void main(String [] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        Future<String> future = threadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(10000L);
                return "complete";
            }
        });
        System.out.println("waiting.........");
        System.out.println("waiting result:" + future.get());
    }
}
