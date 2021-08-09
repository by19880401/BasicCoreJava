package com.example.multithread.demo4;

import cn.hutool.log.StaticLog;
import com.example.multithread.demo1.MyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * synchronized是Java中的关键字，是一种同步锁
 * * 修饰的对象有以下几种：
 * * 　　1. 修饰一个代码块，被修饰的代码块称为同步语句块，其作用的范围是大括号{}括起来的代码，作用的对方是调用这个代码块的对象；
 * * 　　2. 修饰一个方法，被修饰的方法称为同步方法，其作用的范围是整个方法，作用的对方是调用这个方法的对象；
 * * 　　3. 修改一个静态的方法，其作用的范围是整个静态方法，作用的对方是使用这个类的所有对象；
 * * 　　4. 修改一个类，其作用的范围是synchronized后面括号括起来的部分，作用的对方是这个类的所有对象
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
            pool.submit(t);//要保证这里每个线程提交的是同一个对应t
        }
        pool.shutdown();//提交完所有线程任务后，关闭线程池
        StaticLog.info("结束");
    }
}
