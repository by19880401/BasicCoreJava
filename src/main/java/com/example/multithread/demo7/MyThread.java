package com.example.multithread.demo7;

import cn.hutool.log.StaticLog;

/**
 * 修饰一个类
 * <p>
 * Synchronized可作用于一个类，效果和上面synchronized修饰静态方法是一样的
 * synchronized作用于一个类T时，是给这个类T加锁，T的所有对象用的是同一把锁
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/9
 * @
 */
public class MyThread implements Runnable {
    @Override
    public void run() {
        synchronized (MyThread.class) {
            StaticLog.info("线程名：{}在占用这个方法，其它线程请等待", Thread.currentThread().getName());
            try {
                StaticLog.info("{}仍然在用.....", Thread.currentThread().getName());
                Thread.sleep(10000);
                StaticLog.info("{}释放了这个方法，其它线程可以抢了", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                StaticLog.warn("exception now", e);
            }
        }

    }




    /**
     * 执行结果：（一个一个依次抢占资源方法执行）
     * 14:29:48.925 [main] DEBUG cn.hutool.log.LogFactory - Use [Slf4j] Logger As Default.
     * 14:29:48.929 [main] INFO com.example.multithread.demo7.SynchronizedDemo - 结束
     * 14:29:48.930 [pool-1-thread-1] INFO com.example.multithread.demo7.MyThread - 线程名：pool-1-thread-1在占用这个方法，其它线程请等待
     * 14:29:48.930 [pool-1-thread-1] INFO com.example.multithread.demo7.MyThread - pool-1-thread-1仍然在用.....
     * 14:29:58.936 [pool-1-thread-1] INFO com.example.multithread.demo7.MyThread - pool-1-thread-1释放了这个方法，其它线程可以抢了
     * 14:29:58.937 [pool-1-thread-5] INFO com.example.multithread.demo7.MyThread - 线程名：pool-1-thread-5在占用这个方法，其它线程请等待
     * 14:29:58.937 [pool-1-thread-5] INFO com.example.multithread.demo7.MyThread - pool-1-thread-5仍然在用.....
     * 14:30:08.938 [pool-1-thread-5] INFO com.example.multithread.demo7.MyThread - pool-1-thread-5释放了这个方法，其它线程可以抢了
     * 14:30:08.938 [pool-1-thread-4] INFO com.example.multithread.demo7.MyThread - 线程名：pool-1-thread-4在占用这个方法，其它线程请等待
     * 14:30:08.938 [pool-1-thread-4] INFO com.example.multithread.demo7.MyThread - pool-1-thread-4仍然在用.....
     * 14:30:18.953 [pool-1-thread-4] INFO com.example.multithread.demo7.MyThread - pool-1-thread-4释放了这个方法，其它线程可以抢了
     * 14:30:18.954 [pool-1-thread-3] INFO com.example.multithread.demo7.MyThread - 线程名：pool-1-thread-3在占用这个方法，其它线程请等待
     * 14:30:18.954 [pool-1-thread-3] INFO com.example.multithread.demo7.MyThread - pool-1-thread-3仍然在用.....
     * 14:30:28.965 [pool-1-thread-3] INFO com.example.multithread.demo7.MyThread - pool-1-thread-3释放了这个方法，其它线程可以抢了
     * 14:30:28.965 [pool-1-thread-2] INFO com.example.multithread.demo7.MyThread - 线程名：pool-1-thread-2在占用这个方法，其它线程请等待
     * 14:30:28.965 [pool-1-thread-2] INFO com.example.multithread.demo7.MyThread - pool-1-thread-2仍然在用.....
     * 14:30:38.967 [pool-1-thread-2] INFO com.example.multithread.demo7.MyThread - pool-1-thread-2释放了这个方法，其它线程可以抢了
     */
}
