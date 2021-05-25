package com.example.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ThreadPoolMain2 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(2);//允许的线程数据
        for (int i = 0; i < 10; i++) {
            final int num = i;
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();//获取一个令牌，
                        System.out.println("************" + num);//执行操作，打印
                        Thread.sleep(10000l);
                        semaphore.release();//释放一个令牌
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            };
            exec.submit(task);//提交任务至线程池执行
        }
        exec.shutdown();//线程池不再接收任何新任务，但此时线程池并不会立刻退出，直到添加到线程池中的任务都已经处理完成，才会退出
        exec.awaitTermination(1, TimeUnit.HOURS);
        System.out.println("所有线程已结束。。。。。。。。。。。。。。。。");
    }
}
