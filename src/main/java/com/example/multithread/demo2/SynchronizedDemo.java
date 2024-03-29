package com.example.multithread.demo2;

import cn.hutool.log.StaticLog;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * synchronized是Java中的关键字，是一种同步锁
 * 修饰的对象有以下几种：
 * 　　1. 修饰一个代码块，被修饰的代码块称为同步语句块，其作用的范围是大括号{}括起来的代码，作用的对方是调用这个代码块的对象；
 * 　　2. 修饰一个方法，被修饰的方法称为同步方法，其作用的范围是整个方法，作用的对方是调用这个方法的对象；
 * 　　3. 修改一个静态的方法，其作用的范围是整个静态方法，作用的对方是使用这个类的所有对象；
 * 　　4. 修改一个类，其作用的范围是synchronized后面括号括起来的部分，作用的对方是这个类的所有对象
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/6
 * @
 */
public class SynchronizedDemo {

    /**
     * 修饰一个代码块
     * 即：一个线程访问一个对象中的synchronized(this)同步代码块时，其他试图访问该对象的线程将被阻塞
     */
    public static void main(String[] args) {
        //t1,t2,t3,t4,t5传入了不同的线程任务（都是new出来的，不是同一个）,每个任务都有自己的锁、互斥
        /*Thread t1 = new Thread(new MyThread(),"t1");
        Thread t2 = new Thread(new MyThread(),"t2");
        Thread t3 = new Thread(new MyThread(),"t3");
        Thread t4 = new Thread(new MyThread(),"t4");
        Thread t5 = new Thread(new MyThread(),"t5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();*/
        /**下述代码等效上述代码，两者等效*/
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {//模块5个线程，同时执行MyThread1任务
            pool.submit(new MyThread());//如果这样写，则地出现“synchronized”失效的情况，原因是：synchronized只锁定对象，每个对象只有一个锁（lock）与之相关联，现在这样相当于5个线程有5把锁，5把锁是互不干扰的，不形成互斥，所以5个线程可以同时执行，自己干自己的
        }
        pool.shutdown();
        StaticLog.info("结束");
    }

    /**
     * “synchronized”失效,，原因如上述，每个线程任务都是new出来的，不同同一个任务，而new出来的类对象，每个对象只有一个锁（lock）与之相关联，原因如上所述
     */




}
