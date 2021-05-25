package com.example.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ThreadPoolMain {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(2);//允许的线程数据
        for (int i = 0; i < 1000; i++) {
            final int num = i;
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();//获取一个令牌，
                        System.out.println("************" + num);//执行操作，打印
                        semaphore.release();//释放一个令牌
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            };
            exec.submit(task);//提交任务至线程池执行
        }
        exec.shutdown();//线程池不再接收任何新任务，但此时线程池并不会立刻退出，直到添加到线程池中的任务都已经处理完成，才会退出
        while (true) {
            if (exec.isTerminated()) {//是否线程池中的所有线程已经执行完毕
                System.out.println("所有线程已结束。。。。。。。。。。。。。。。。");
                break;
            }
        }
    }
}

/**
 * semaphore.acquire()
 * 1、当前线程会尝试去同步队列获取一个令牌，获取令牌的过程也就是使用原子的操作去修改同步队列的state ,获取一个令牌则修改为state=state-1。
 * 2、 当计算出来的state<0，则代表令牌数量不足，此时会创建一个Node节点加入阻塞队列，挂起当前线程。
 * 3、当计算出来的state>=0，则代表获取令牌成功
 *
 * semaphore.release()
 * 1、线程会尝试释放一个令牌，释放令牌的过程也就是把同步队列的state修改为state=state+1的过程
 * 2、释放令牌成功之后，同时会唤醒同步队列的所有阻塞节共享节点线程
 * 3、被唤醒的节点会重新尝试去修改state=state-1 的操作，如果state>=0则获取令牌成功，否则重新进入阻塞队列，挂起线程
 */
