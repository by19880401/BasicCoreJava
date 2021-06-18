package com.example.threadpool;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 使用CountDownLatch实现所有线程都全部执行完毕后，代码再往下继续执行的控制方法
 * 
 * @author baiyang
 * @date 2021/6/18
 */
public class MultipleThreadDemo4 {
    /**
     * 在Java的多线程中，有的时候我们需要等某些多线程的方法全部都执行完毕后，才继续往下执行。这个该怎么控制呢？用CountDownLatch类。
     * 这个类是java.util.concurrent包里面，也即是Java的并发工具包，这个包里面有很多多线程的工具类，在多线程编程中很有用
     *
     * 下述示例就是一个CountDownLatch类的一个用法。比如我们有五个人（五个线程），他们都赶往同一目的地，但是我们不知道他们什么时候才能赶来，或许1秒，或许9秒，或许更长。
     * 然后我们接下来的事情需要五个人都到齐了才能继续往下做。这就需要进行多线程控制。
     * 
     * @param args
     */
    public static void main(String[] args) {
        // 执行多线程之前的代码，本例中就是通知大家到目的地
        System.out.println("通知，大家快来这个地方");
        System.out.println("=========== 可以理解为多线程之前 ===========");

        // 总的线程数为5（大家可以换这个变量，进行调试）
        int threadNum = 5;
        // 创建一个CountDownLatch类，构造入参线程数
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        // 创建5个线程，并发同步执行
        for (int i = 0; i < threadNum; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 10000以内的随机数，作为等待时间
                    int waitMillis = new Random().nextInt(10000);

                    try {
                        // 模拟线程执行，耗费一定的时间（本例是10秒内）
                        Thread.sleep(waitMillis);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // 线程执行完毕，报告结果
                    System.out.println(Thread.currentThread().getName() + "已到达目的地，所用毫秒数：" + waitMillis);

                    // CountDownLatch类计数减一
                    // 注意，CountDownLatch类的实例要在新建多线程之前，然后入参需要
                    // 统一完成后才往下执行的线程数。然后每个线程执行完后，或者
                    // 部分执行完后，调用之前创建的CountDownLatch类的实例的countDown方法
                    countDownLatch.countDown();
                }
            }).start();
        }

        try {
            /**
             * 下面这句代码，CountDownLatch就阻塞在这里了 直到countDown()到0了（从构造入参的线程数开始减） 也即是所有线程都countDown了， 则解除阻塞，代码继续往下执行
             * 注意，这句代码放在多线程countDown之后，多线程全部完成后 继续往下执行的代码之前，起一个分界线的作用
             */
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 由于CountDownLatch发挥的作用，等到上面的5个线程都执行完毕了，
        // 也就是都打印了"已到达目的地"，接下来才会往下执行，打印下面这句话
        System.out.println("=========== 可以理解为多线程之后 ===========");
        System.out.println("大家都到齐了，那就开始吧");

        /**
         * 程序执行结果： 通知，大家快来这个地方 =========== 可以理解为多线程之前 =========== Thread-0已到达目的地，所用毫秒数：3323 Thread-4已到达目的地，所用毫秒数：4153
         * Thread-3已到达目的地，所用毫秒数：4381 Thread-2已到达目的地，所用毫秒数：5306 Thread-1已到达目的地，所用毫秒数：8984 =========== 可以理解为多线程之后
         * =========== 大家都到齐了，那就开始吧
         */

    }
}
