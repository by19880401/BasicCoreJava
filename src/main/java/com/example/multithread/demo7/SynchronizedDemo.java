package com.example.multithread.demo7;

import cn.hutool.log.StaticLog;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 修饰一个类
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/9
 * @
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        MyThread t = new MyThread();//同一个线程任务t
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {//模拟5个线程，同时执行MyThread任务
            pool.submit(t);//每提交一次，表示一个新的对象，所有会有5个对象
        }
        pool.shutdown();
        StaticLog.info("结束");
    }
}
