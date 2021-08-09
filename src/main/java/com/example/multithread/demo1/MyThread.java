package com.example.multithread.demo1;

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
     * CASE1:如果没有synchronized关键字，执行结果：（可以看到在17:21:15.684这一时刻，5个线程一哄而上，同时抢占这个方法，同时并行使用这个方法）
     * 17:21:15.683 [main] INFO com.example.multithread.demo1.SynchronizedDemo1 - 结束
     * 17:21:15.684 [pool-1-thread-1] INFO com.example.multithread.demo1.MyThread1 - 线程名：pool-1-thread-1在占用这个方法，其它线程请等待
     * 17:21:15.684 [pool-1-thread-2] INFO com.example.multithread.demo1.MyThread1 - 线程名：pool-1-thread-2在占用这个方法，其它线程请等待
     * 17:21:15.684 [pool-1-thread-2] INFO com.example.multithread.demo1.MyThread1 - pool-1-thread-2仍然在用.....
     * 17:21:15.684 [pool-1-thread-5] INFO com.example.multithread.demo1.MyThread1 - 线程名：pool-1-thread-5在占用这个方法，其它线程请等待
     * 17:21:15.684 [pool-1-thread-5] INFO com.example.multithread.demo1.MyThread1 - pool-1-thread-5仍然在用.....
     * 17:21:15.684 [pool-1-thread-4] INFO com.example.multithread.demo1.MyThread1 - 线程名：pool-1-thread-4在占用这个方法，其它线程请等待
     * 17:21:15.684 [pool-1-thread-3] INFO com.example.multithread.demo1.MyThread1 - 线程名：pool-1-thread-3在占用这个方法，其它线程请等待
     * 17:21:15.685 [pool-1-thread-3] INFO com.example.multithread.demo1.MyThread1 - pool-1-thread-3仍然在用.....
     * 17:21:15.685 [pool-1-thread-1] INFO com.example.multithread.demo1.MyThread1 - pool-1-thread-1仍然在用.....
     * 17:21:15.685 [pool-1-thread-4] INFO com.example.multithread.demo1.MyThread1 - pool-1-thread-4仍然在用.....
     * 17:21:25.695 [pool-1-thread-3] INFO com.example.multithread.demo1.MyThread1 - pool-1-thread-3释放了这个方法，其它线程可以抢了
     * 17:21:25.695 [pool-1-thread-4] INFO com.example.multithread.demo1.MyThread1 - pool-1-thread-4释放了这个方法，其它线程可以抢了
     * 17:21:25.695 [pool-1-thread-1] INFO com.example.multithread.demo1.MyThread1 - pool-1-thread-1释放了这个方法，其它线程可以抢了
     * 17:21:25.695 [pool-1-thread-2] INFO com.example.multithread.demo1.MyThread1 - pool-1-thread-2释放了这个方法，其它线程可以抢了
     * 17:21:25.695 [pool-1-thread-5] INFO com.example.multithread.demo1.MyThread1 - pool-1-thread-5释放了这个方法，其它线程可以抢了
     */

    /**
     * CASE2:有synchronized关键字时，执行结果：（所有线程在哄抢着想要占用执行这个方法，但每次总是只能有一个线程占用执行此方法，其它线程都只能等待它执行完毕，换句话说，同一时刻，保证只有一个线程在占用执行此方法）
     * 17:26:55.658 [main] INFO com.example.multithread.demo1.SynchronizedDemo1 - 结束
     * 17:26:55.659 [pool-1-thread-1] INFO com.example.multithread.demo1.MyThread1 - 线程名：pool-1-thread-1在占用这个方法，其它线程请等待
     * 17:26:55.659 [pool-1-thread-1] INFO com.example.multithread.demo1.MyThread1 - pool-1-thread-1仍然在用.....
     * 17:27:05.660 [pool-1-thread-1] INFO com.example.multithread.demo1.MyThread1 - pool-1-thread-1释放了这个方法，其它线程可以抢了
     * 17:27:05.661 [pool-1-thread-5] INFO com.example.multithread.demo1.MyThread1 - 线程名：pool-1-thread-5在占用这个方法，其它线程请等待
     * 17:27:05.661 [pool-1-thread-5] INFO com.example.multithread.demo1.MyThread1 - pool-1-thread-5仍然在用.....
     * 17:27:15.665 [pool-1-thread-5] INFO com.example.multithread.demo1.MyThread1 - pool-1-thread-5释放了这个方法，其它线程可以抢了
     * 17:27:15.665 [pool-1-thread-4] INFO com.example.multithread.demo1.MyThread1 - 线程名：pool-1-thread-4在占用这个方法，其它线程请等待
     * 17:27:15.665 [pool-1-thread-4] INFO com.example.multithread.demo1.MyThread1 - pool-1-thread-4仍然在用.....
     * 17:27:25.676 [pool-1-thread-4] INFO com.example.multithread.demo1.MyThread1 - pool-1-thread-4释放了这个方法，其它线程可以抢了
     * 17:27:25.676 [pool-1-thread-3] INFO com.example.multithread.demo1.MyThread1 - 线程名：pool-1-thread-3在占用这个方法，其它线程请等待
     * 17:27:25.676 [pool-1-thread-3] INFO com.example.multithread.demo1.MyThread1 - pool-1-thread-3仍然在用.....
     * 17:27:35.679 [pool-1-thread-3] INFO com.example.multithread.demo1.MyThread1 - pool-1-thread-3释放了这个方法，其它线程可以抢了
     * 17:27:35.680 [pool-1-thread-2] INFO com.example.multithread.demo1.MyThread1 - 线程名：pool-1-thread-2在占用这个方法，其它线程请等待
     * 17:27:35.680 [pool-1-thread-2] INFO com.example.multithread.demo1.MyThread1 - pool-1-thread-2仍然在用.....
     * 17:27:45.691 [pool-1-thread-2] INFO com.example.multithread.demo1.MyThread1 - pool-1-thread-2释放了这个方法，其它线程可以抢了
     */
}
