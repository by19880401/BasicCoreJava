package com.example.multithread.demo2;

import cn.hutool.log.StaticLog;

/**
 * 修饰一个代码块
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/6
 * @
 */
public class MyThread implements Runnable {

    @Override
    public void run() {
        // 创建一个代码块
        synchronized (this) {//CASE1，注掉了这一行代码；CASE2放开这一行代码
            StaticLog.info("线程名：{}在占用这个方法，其它线程请等待", Thread.currentThread().getName());
            try {
                StaticLog.info("{}仍然在用.....", Thread.currentThread().getName());
                Thread.sleep(10000);
                StaticLog.info("{}释放了这个方法，其它线程可以抢了", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                StaticLog.warn("exception now", e);
            }
        }//CASE1，注掉了这一行代码；CASE2放开这一行代码
    }

    /***
     * CASE1:如果没有synchronized关键字，执行结果：（可以看到在13:57:23.494这一时刻，5个线程一哄而上，同时抢占这个方法，同时并行使用这个方法）
     * 13:57:23.482 [main] INFO com.example.multithread.demo2.SynchronizedDemo - 结束
     * 13:57:23.494 [pool-1-thread-2] INFO com.example.multithread.demo2.MyThread - 线程名：pool-1-thread-2在占用这个方法，其它线程请等待
     * 13:57:23.494 [pool-1-thread-1] INFO com.example.multithread.demo2.MyThread - 线程名：pool-1-thread-1在占用这个方法，其它线程请等待
     * 13:57:23.494 [pool-1-thread-2] INFO com.example.multithread.demo2.MyThread - pool-1-thread-2仍然在用.....
     * 13:57:23.494 [pool-1-thread-1] INFO com.example.multithread.demo2.MyThread - pool-1-thread-1仍然在用.....
     * 13:57:23.494 [pool-1-thread-3] INFO com.example.multithread.demo2.MyThread - 线程名：pool-1-thread-3在占用这个方法，其它线程请等待
     * 13:57:23.494 [pool-1-thread-4] INFO com.example.multithread.demo2.MyThread - 线程名：pool-1-thread-4在占用这个方法，其它线程请等待
     * 13:57:23.494 [pool-1-thread-3] INFO com.example.multithread.demo2.MyThread - pool-1-thread-3仍然在用.....
     * 13:57:23.494 [pool-1-thread-5] INFO com.example.multithread.demo2.MyThread - 线程名：pool-1-thread-5在占用这个方法，其它线程请等待
     * 13:57:23.494 [pool-1-thread-4] INFO com.example.multithread.demo2.MyThread - pool-1-thread-4仍然在用.....
     * 13:57:23.494 [pool-1-thread-5] INFO com.example.multithread.demo2.MyThread - pool-1-thread-5仍然在用.....
     * 13:57:33.513 [pool-1-thread-2] INFO com.example.multithread.demo2.MyThread - pool-1-thread-2释放了这个方法，其它线程可以抢了
     * 13:57:33.513 [pool-1-thread-1] INFO com.example.multithread.demo2.MyThread - pool-1-thread-1释放了这个方法，其它线程可以抢了
     * 13:57:33.513 [pool-1-thread-5] INFO com.example.multithread.demo2.MyThread - pool-1-thread-5释放了这个方法，其它线程可以抢了
     * 13:57:33.513 [pool-1-thread-3] INFO com.example.multithread.demo2.MyThread - pool-1-thread-3释放了这个方法，其它线程可以抢了
     * 13:57:33.513 [pool-1-thread-4] INFO com.example.multithread.demo2.MyThread - pool-1-thread-4释放了这个方法，其它线程可以抢了
     */

    /**
     * CASE2:有synchronized关键字时，执行结果：（可以看到在13:58:52.291这一时刻，5个线程一哄而上，同时抢占这个方法，同时并行使用这个方法）
     * 13:58:52.290 [main] INFO com.example.multithread.demo2.SynchronizedDemo - 结束
     * 13:58:52.291 [pool-1-thread-5] INFO com.example.multithread.demo2.MyThread - 线程名：pool-1-thread-5在占用这个方法，其它线程请等待
     * 13:58:52.291 [pool-1-thread-3] INFO com.example.multithread.demo2.MyThread - 线程名：pool-1-thread-3在占用这个方法，其它线程请等待
     * 13:58:52.291 [pool-1-thread-5] INFO com.example.multithread.demo2.MyThread - pool-1-thread-5仍然在用.....
     * 13:58:52.291 [pool-1-thread-3] INFO com.example.multithread.demo2.MyThread - pool-1-thread-3仍然在用.....
     * 13:58:52.291 [pool-1-thread-2] INFO com.example.multithread.demo2.MyThread - 线程名：pool-1-thread-2在占用这个方法，其它线程请等待
     * 13:58:52.291 [pool-1-thread-1] INFO com.example.multithread.demo2.MyThread - 线程名：pool-1-thread-1在占用这个方法，其它线程请等待
     * 13:58:52.292 [pool-1-thread-1] INFO com.example.multithread.demo2.MyThread - pool-1-thread-1仍然在用.....
     * 13:58:52.291 [pool-1-thread-4] INFO com.example.multithread.demo2.MyThread - 线程名：pool-1-thread-4在占用这个方法，其它线程请等待
     * 13:58:52.292 [pool-1-thread-2] INFO com.example.multithread.demo2.MyThread - pool-1-thread-2仍然在用.....
     * 13:58:52.292 [pool-1-thread-4] INFO com.example.multithread.demo2.MyThread - pool-1-thread-4仍然在用.....
     * 13:59:02.298 [pool-1-thread-5] INFO com.example.multithread.demo2.MyThread - pool-1-thread-5释放了这个方法，其它线程可以抢了
     * 13:59:02.298 [pool-1-thread-2] INFO com.example.multithread.demo2.MyThread - pool-1-thread-2释放了这个方法，其它线程可以抢了
     * 13:59:02.298 [pool-1-thread-1] INFO com.example.multithread.demo2.MyThread - pool-1-thread-1释放了这个方法，其它线程可以抢了
     * 13:59:02.298 [pool-1-thread-3] INFO com.example.multithread.demo2.MyThread - pool-1-thread-3释放了这个方法，其它线程可以抢了
     * 13:59:02.298 [pool-1-thread-4] INFO com.example.multithread.demo2.MyThread - pool-1-thread-4释放了这个方法，其它线程可以抢了
     */

    /**
     * 为何synchronized会“失效”，原因见SynchronizedDemo.java里的描述
     */
}
