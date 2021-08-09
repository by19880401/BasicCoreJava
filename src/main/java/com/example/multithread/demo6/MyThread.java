package com.example.multithread.demo6;

import cn.hutool.log.StaticLog;

/**
 * 修饰一个静态的方法
 *Synchronized也可修饰一个静态方法，用法如下：
 *
 * public synchronized static void method() {
 *          // todo
 * }
 *
 * 静态方法是属于类的而不属于对象的。同样的，synchronized修饰的静态方法锁定的是这个类的所有对象（即锁定使用这个静态类的所有对象）
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/9
 * @
 */
public class MyThread implements Runnable {
    @Override
    public void run() {
        printInfo();
    }

    /**
     * 5个线程，5个对象，分别是t1,t2,t3,t4,t5，它们是MyThread的5个对象，这5个线程并发执行时却保持了线程同步，
     * 这是因为run中调用了静态方法printInfo，而静态方法是属于类的，所以t1,t2,t3,t4,t5相当于用了同一把锁
     * 这与使用关键字synchronized运行结果相同
     */
    private synchronized static void printInfo() {
        StaticLog.info("线程名：{}在占用这个方法，其它线程请等待", Thread.currentThread().getName());
        try {
            StaticLog.info("{}仍然在用.....", Thread.currentThread().getName());
            Thread.sleep(10000);
            StaticLog.info("{}释放了这个方法，其它线程可以抢了", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            StaticLog.warn("exception now", e);
        }
    }


    /**执行结果：（一个一个依次抢占资源方法执行）
     * 17:56:03.058 [main] INFO com.example.multithread.demo6.SynchronizedDemo - 结束
     * 17:56:03.059 [pool-1-thread-1] INFO com.example.multithread.demo6.MyThread - 线程名：pool-1-thread-1在占用这个方法，其它线程请等待
     * 17:56:03.059 [pool-1-thread-1] INFO com.example.multithread.demo6.MyThread - pool-1-thread-1仍然在用.....
     * 17:56:13.062 [pool-1-thread-1] INFO com.example.multithread.demo6.MyThread - pool-1-thread-1释放了这个方法，其它线程可以抢了
     * 17:56:13.062 [pool-1-thread-5] INFO com.example.multithread.demo6.MyThread - 线程名：pool-1-thread-5在占用这个方法，其它线程请等待
     * 17:56:13.062 [pool-1-thread-5] INFO com.example.multithread.demo6.MyThread - pool-1-thread-5仍然在用.....
     * 17:56:23.070 [pool-1-thread-5] INFO com.example.multithread.demo6.MyThread - pool-1-thread-5释放了这个方法，其它线程可以抢了
     * 17:56:23.070 [pool-1-thread-4] INFO com.example.multithread.demo6.MyThread - 线程名：pool-1-thread-4在占用这个方法，其它线程请等待
     * 17:56:23.070 [pool-1-thread-4] INFO com.example.multithread.demo6.MyThread - pool-1-thread-4仍然在用.....
     * 17:56:33.078 [pool-1-thread-4] INFO com.example.multithread.demo6.MyThread - pool-1-thread-4释放了这个方法，其它线程可以抢了
     * 17:56:33.078 [pool-1-thread-3] INFO com.example.multithread.demo6.MyThread - 线程名：pool-1-thread-3在占用这个方法，其它线程请等待
     * 17:56:33.078 [pool-1-thread-3] INFO com.example.multithread.demo6.MyThread - pool-1-thread-3仍然在用.....
     * 17:56:43.088 [pool-1-thread-3] INFO com.example.multithread.demo6.MyThread - pool-1-thread-3释放了这个方法，其它线程可以抢了
     * 17:56:43.088 [pool-1-thread-2] INFO com.example.multithread.demo6.MyThread - 线程名：pool-1-thread-2在占用这个方法，其它线程请等待
     * 17:56:43.088 [pool-1-thread-2] INFO com.example.multithread.demo6.MyThread - pool-1-thread-2仍然在用.....
     * 17:56:53.096 [pool-1-thread-2] INFO com.example.multithread.demo6.MyThread - pool-1-thread-2释放了这个方法，其它线程可以抢了
     */
}
