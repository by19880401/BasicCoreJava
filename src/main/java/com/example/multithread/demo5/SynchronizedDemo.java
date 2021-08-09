package com.example.multithread.demo5;

import cn.hutool.log.StaticLog;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用synchronized修饰方法时要注意以下几点：
 * 虽然可以使用synchronized来定义方法，但synchronized并不属于方法定义的一部分,因此，synchronized关键字不能被继承
 * 如果在父类中的某个方法使用了synchronized关键字，而在子类中覆盖了这个方法，则在子类中的这个方法默认情况下并不是synchronized的
 * 而必须显式地在子类的这个方法中加上synchronized关键字才可以
 * <p>
 * 当然，还可以在子类方法中调用父类中相应的方法，这样虽然子类中的方法不是同步的，但子类调用了父类的同步方法，因此，子类的方法也就相当于同步了
 *
 *
 * Tips:重要，重要，重要
 * 1）在定义接口方法时不能使用synchronized关键字
 * 2）构造方法不能使用synchronized关键字，但可以使用synchronized代码块来进行同步
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
