package com.example.multithread.ReentrantLock;

import cn.hutool.log.StaticLog;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 可重入锁举例
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/12
 * @
 */
public class Main {
    public static void main(String[] args) {
        LockDemo thread = new LockDemo();
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {//模拟5个线程，同时执行MyThread任务
            pool.submit(thread);//每提交一次，表示一个新的对象，所有会有5个对象
        }
        pool.shutdown();
        StaticLog.info("结束");
    }
}
