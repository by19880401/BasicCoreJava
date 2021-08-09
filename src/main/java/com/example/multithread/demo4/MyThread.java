package com.example.multithread.demo4;

import cn.hutool.log.StaticLog;

/**
 * 修饰一个方法
 * <p>
 * Synchronized修饰一个方法很简单，就是在方法的前面加synchronized
 * synchronized修饰方法和修饰一个代码块类似，只是作用范围不一样，修饰代码块是大括号括起来的范围，而修饰方法范围是整个函数
 *
 * Synchronized作用于整个方法的写法:（写法一与写法二是等价的，都是锁定了整个方法时的内容）
 * 写法一：（修饰的是一个方法）
 * public synchronized void method()
 * {
 *    // todo
 * }
 *
 * 写法二：（修饰的是一个代码块）
 * public void method()
 * {
 *    synchronized(this) {
 *
 *    }
 * }
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/9
 * @
 */
public class MyThread implements Runnable {
    @Override
    public synchronized void run() {// 写法1，synchronized直接加在方法上，修饰一个方法，功能等效等同下述写法2
        StaticLog.info("线程名：{}在占用这个方法，其它线程请等待", Thread.currentThread().getName());
        try {
            StaticLog.info("{}仍然在用.....", Thread.currentThread().getName());
            Thread.sleep(10000);
            StaticLog.info("{}释放了这个方法，其它线程可以抢了", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            StaticLog.warn("exception now", e);
        }
    }

    /*@Override
    public void run() {
        // 创建一个代码块
        synchronized (this) {//写法2，synchronized修饰一个代码块类似，功能等效等同下述写法1
            StaticLog.info("线程名：{}在占用这个方法，其它线程请等待", Thread.currentThread().getName());
            try {
                StaticLog.info("{}仍然在用.....", Thread.currentThread().getName());
                Thread.sleep(10000);
                StaticLog.info("{}释放了这个方法，其它线程可以抢了", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                StaticLog.warn("exception now", e);
            }
        }
    }*/


    /**
     * 结果如下：（所有线程在哄抢着想要占用执行这个方法，但每次总是只能有一个线程占用执行此方法，其它线程都只能等待它执行完毕，换句话说，同一时刻，保证只有一个线程在占用执行此方法）
     * 15:28:41.342 [main] DEBUG cn.hutool.log.LogFactory - Use [Slf4j] Logger As Default.
     * 15:28:41.345 [main] INFO com.example.multithread.demo4.SynchronizedDemo - 结束
     * 15:28:41.359 [pool-1-thread-1] INFO com.example.multithread.demo1.MyThread - 线程名：pool-1-thread-1在占用这个方法，其它线程请等待
     * 15:28:41.359 [pool-1-thread-1] INFO com.example.multithread.demo1.MyThread - pool-1-thread-1仍然在用.....
     * 15:28:51.363 [pool-1-thread-1] INFO com.example.multithread.demo1.MyThread - pool-1-thread-1释放了这个方法，其它线程可以抢了
     * 15:28:51.363 [pool-1-thread-5] INFO com.example.multithread.demo1.MyThread - 线程名：pool-1-thread-5在占用这个方法，其它线程请等待
     * 15:28:51.364 [pool-1-thread-5] INFO com.example.multithread.demo1.MyThread - pool-1-thread-5仍然在用.....
     * 15:29:01.372 [pool-1-thread-5] INFO com.example.multithread.demo1.MyThread - pool-1-thread-5释放了这个方法，其它线程可以抢了
     * 15:29:01.372 [pool-1-thread-4] INFO com.example.multithread.demo1.MyThread - 线程名：pool-1-thread-4在占用这个方法，其它线程请等待
     * 15:29:01.372 [pool-1-thread-4] INFO com.example.multithread.demo1.MyThread - pool-1-thread-4仍然在用.....
     * 15:29:11.380 [pool-1-thread-4] INFO com.example.multithread.demo1.MyThread - pool-1-thread-4释放了这个方法，其它线程可以抢了
     * 15:29:11.380 [pool-1-thread-3] INFO com.example.multithread.demo1.MyThread - 线程名：pool-1-thread-3在占用这个方法，其它线程请等待
     * 15:29:11.380 [pool-1-thread-3] INFO com.example.multithread.demo1.MyThread - pool-1-thread-3仍然在用.....
     * 15:29:21.388 [pool-1-thread-3] INFO com.example.multithread.demo1.MyThread - pool-1-thread-3释放了这个方法，其它线程可以抢了
     * 15:29:21.388 [pool-1-thread-2] INFO com.example.multithread.demo1.MyThread - 线程名：pool-1-thread-2在占用这个方法，其它线程请等待
     * 15:29:21.388 [pool-1-thread-2] INFO com.example.multithread.demo1.MyThread - pool-1-thread-2仍然在用.....
     * 15:29:31.396 [pool-1-thread-2] INFO com.example.multithread.demo1.MyThread - pool-1-thread-2释放了这个方法，其它线程可以抢了
     */


}
