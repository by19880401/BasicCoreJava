package com.example.multithread.ReentrantLock;

import cn.hutool.log.StaticLog;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 多个线程在运行时，执行操作A的过程时，需要同时执行操作B才能完成A的操作，操作A和操作B都是原子操作，都需要锁定才能执行，但正常情况下对象的锁每次只能被一个线程获得，锁定并执行一个操作（要么A，要么B）；
 * 这里的可重入锁地可以让该线程在锁定执行操作A时，再次重入获取到锁锁定操作B，完成所有操作后，依次释放锁
 * Tps：操作A和操作B得到的锁，是同一把锁，这把锁可以被重入获取多次，所以叫可重入锁
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/12
 * @
 */
public class LockDemo implements Runnable {
    ReentrantLock reentrantLock = new ReentrantLock();// JDK实现的可重入锁

    @Override
    public void run() {
        operationA();
    }

    public void operationA() {
        // 上锁
        reentrantLock.lock();
        // 锁定成功，开始原子操作
        StaticLog.info("A锁定，开始操作A");
        // 原子操作A时，需要用到原子操作B才能完成完整的操作A
        operationB();
        //操作完成，解锁
        StaticLog.info("A释放，操作A完成");
        reentrantLock.unlock();

    }

    public void operationB() {
        //上锁,调用lock成功，锁定成功，说明lock是可重入锁；因为如果是不可重入锁，此处会上锁失败
        reentrantLock.lock();
        // 开始原子操作
        StaticLog.info("B锁定，开始操作B");
        // 操作完成，解锁
        StaticLog.info("B释放，操作B完成");
        reentrantLock.unlock();
    }


    /**
     * 15:25:18.144 [pool-1-thread-1] INFO com.example.multithread.ReentrantLock.LockDemo - A锁定，开始操作A
     * 15:25:18.144 [pool-1-thread-1] INFO com.example.multithread.ReentrantLock.LockDemo - B锁定，开始操作B
     * 15:25:18.144 [pool-1-thread-1] INFO com.example.multithread.ReentrantLock.LockDemo - B释放，操作B完成
     * 15:25:18.144 [pool-1-thread-1] INFO com.example.multithread.ReentrantLock.LockDemo - A释放，操作A完成
     * 15:25:18.144 [pool-1-thread-2] INFO com.example.multithread.ReentrantLock.LockDemo - A锁定，开始操作A
     * 15:25:18.144 [pool-1-thread-2] INFO com.example.multithread.ReentrantLock.LockDemo - B锁定，开始操作B
     * 15:25:18.144 [pool-1-thread-2] INFO com.example.multithread.ReentrantLock.LockDemo - B释放，操作B完成
     * 15:25:18.144 [pool-1-thread-2] INFO com.example.multithread.ReentrantLock.LockDemo - A释放，操作A完成
     * 15:25:18.144 [pool-1-thread-3] INFO com.example.multithread.ReentrantLock.LockDemo - A锁定，开始操作A
     * 15:25:18.145 [pool-1-thread-3] INFO com.example.multithread.ReentrantLock.LockDemo - B锁定，开始操作B
     * 15:25:18.145 [pool-1-thread-3] INFO com.example.multithread.ReentrantLock.LockDemo - B释放，操作B完成
     * 15:25:18.145 [pool-1-thread-3] INFO com.example.multithread.ReentrantLock.LockDemo - A释放，操作A完成
     * 15:25:18.145 [pool-1-thread-4] INFO com.example.multithread.ReentrantLock.LockDemo - A锁定，开始操作A
     * 15:25:18.145 [pool-1-thread-4] INFO com.example.multithread.ReentrantLock.LockDemo - B锁定，开始操作B
     * 15:25:18.145 [pool-1-thread-4] INFO com.example.multithread.ReentrantLock.LockDemo - B释放，操作B完成
     * 15:25:18.145 [pool-1-thread-4] INFO com.example.multithread.ReentrantLock.LockDemo - A释放，操作A完成
     * 15:25:18.145 [pool-1-thread-5] INFO com.example.multithread.ReentrantLock.LockDemo - A锁定，开始操作A
     * 15:25:18.145 [pool-1-thread-5] INFO com.example.multithread.ReentrantLock.LockDemo - B锁定，开始操作B
     * 15:25:18.145 [pool-1-thread-5] INFO com.example.multithread.ReentrantLock.LockDemo - B释放，操作B完成
     * 15:25:18.145 [pool-1-thread-5] INFO com.example.multithread.ReentrantLock.LockDemo - A释放，操作A完成
     */
}
