package com.example.multithread.demo5;

import cn.hutool.log.StaticLog;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/9
 * @
 */
public class Child extends Parent{
    @Override
    public synchronized void printInfo() { // CASE1:有synchronized
//    public void printInfo() { // CASE2:无synchronized
        StaticLog.info("【子类】-线程名：{}在占用这个方法，其它线程请等待", Thread.currentThread().getName());
        try {
            StaticLog.info("【子类】-{}仍然在用.....", Thread.currentThread().getName());
            Thread.sleep(10000);
            StaticLog.info("【子类】-{}释放了这个方法，其它线程可以抢了", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            StaticLog.warn("【子类】-exception now", e);
        }
    }

    /**
     * 可以在子类方法中调用父类中相应的synchronized方法，这样虽然子类中的方法不是同步的，但子类调用了父类的synchronized方法，因此，子类的方法也就相当于synchronized了
     *
     * 执行结果：
     * 17:42:37.163 [main] INFO com.example.multithread.demo5.SynchronizedDemo - 结束
     * 17:42:37.164 [pool-1-thread-1] INFO com.example.multithread.demo5.Parent - 【父类】-线程名：pool-1-thread-1在占用这个方法，其它线程请等待
     * 17:42:37.165 [pool-1-thread-1] INFO com.example.multithread.demo5.Parent - 【父类】-pool-1-thread-1仍然在用.....
     * 17:42:47.174 [pool-1-thread-1] INFO com.example.multithread.demo5.Parent - 【父类】-pool-1-thread-1释放了这个方法，其它线程可以抢了
     * 17:42:47.174 [pool-1-thread-5] INFO com.example.multithread.demo5.Parent - 【父类】-线程名：pool-1-thread-5在占用这个方法，其它线程请等待
     * 17:42:47.174 [pool-1-thread-5] INFO com.example.multithread.demo5.Parent - 【父类】-pool-1-thread-5仍然在用.....
     * 17:42:57.185 [pool-1-thread-5] INFO com.example.multithread.demo5.Parent - 【父类】-pool-1-thread-5释放了这个方法，其它线程可以抢了
     * 17:42:57.185 [pool-1-thread-4] INFO com.example.multithread.demo5.Parent - 【父类】-线程名：pool-1-thread-4在占用这个方法，其它线程请等待
     * 17:42:57.185 [pool-1-thread-4] INFO com.example.multithread.demo5.Parent - 【父类】-pool-1-thread-4仍然在用.....
     * 17:43:07.194 [pool-1-thread-4] INFO com.example.multithread.demo5.Parent - 【父类】-pool-1-thread-4释放了这个方法，其它线程可以抢了
     * 17:43:07.194 [pool-1-thread-3] INFO com.example.multithread.demo5.Parent - 【父类】-线程名：pool-1-thread-3在占用这个方法，其它线程请等待
     * 17:43:07.194 [pool-1-thread-3] INFO com.example.multithread.demo5.Parent - 【父类】-pool-1-thread-3仍然在用.....
     * 17:43:17.195 [pool-1-thread-3] INFO com.example.multithread.demo5.Parent - 【父类】-pool-1-thread-3释放了这个方法，其它线程可以抢了
     * 17:43:17.195 [pool-1-thread-2] INFO com.example.multithread.demo5.Parent - 【父类】-线程名：pool-1-thread-2在占用这个方法，其它线程请等待
     * 17:43:17.195 [pool-1-thread-2] INFO com.example.multithread.demo5.Parent - 【父类】-pool-1-thread-2仍然在用.....
     * 17:43:27.207 [pool-1-thread-2] INFO com.example.multithread.demo5.Parent - 【父类】-pool-1-thread-2释放了这个方法，其它线程可以抢了
     */
    public void callParentPrintInfo(){
        super.printInfo();
    }


    /**
     * CASE1:(有synchronized)修饰时，执行结果如下：（线程一个一个依次抢夺占用printInfo，说明父类的synchronized方法无法被子类继承）
     * 17:35:59.619 [pool-1-thread-5] INFO com.example.multithread.demo5.Child - 【子类】-线程名：pool-1-thread-5在占用这个方法，其它线程请等待
     * 17:35:59.620 [pool-1-thread-5] INFO com.example.multithread.demo5.Child - 【子类】-pool-1-thread-5仍然在用.....
     * 17:35:59.620 [main] INFO com.example.multithread.demo5.SynchronizedDemo - 结束
     * 17:36:09.620 [pool-1-thread-5] INFO com.example.multithread.demo5.Child - 【子类】-pool-1-thread-5释放了这个方法，其它线程可以抢了
     * 17:36:09.620 [pool-1-thread-1] INFO com.example.multithread.demo5.Child - 【子类】-线程名：pool-1-thread-1在占用这个方法，其它线程请等待
     * 17:36:09.620 [pool-1-thread-1] INFO com.example.multithread.demo5.Child - 【子类】-pool-1-thread-1仍然在用.....
     * 17:36:19.629 [pool-1-thread-1] INFO com.example.multithread.demo5.Child - 【子类】-pool-1-thread-1释放了这个方法，其它线程可以抢了
     * 17:36:19.629 [pool-1-thread-2] INFO com.example.multithread.demo5.Child - 【子类】-线程名：pool-1-thread-2在占用这个方法，其它线程请等待
     * 17:36:19.629 [pool-1-thread-2] INFO com.example.multithread.demo5.Child - 【子类】-pool-1-thread-2仍然在用.....
     * 17:36:29.638 [pool-1-thread-2] INFO com.example.multithread.demo5.Child - 【子类】-pool-1-thread-2释放了这个方法，其它线程可以抢了
     * 17:36:29.638 [pool-1-thread-3] INFO com.example.multithread.demo5.Child - 【子类】-线程名：pool-1-thread-3在占用这个方法，其它线程请等待
     * 17:36:29.638 [pool-1-thread-3] INFO com.example.multithread.demo5.Child - 【子类】-pool-1-thread-3仍然在用.....
     * 17:36:39.647 [pool-1-thread-3] INFO com.example.multithread.demo5.Child - 【子类】-pool-1-thread-3释放了这个方法，其它线程可以抢了
     * 17:36:39.647 [pool-1-thread-4] INFO com.example.multithread.demo5.Child - 【子类】-线程名：pool-1-thread-4在占用这个方法，其它线程请等待
     * 17:36:39.647 [pool-1-thread-4] INFO com.example.multithread.demo5.Child - 【子类】-pool-1-thread-4仍然在用.....
     * 17:36:49.657 [pool-1-thread-4] INFO com.example.multithread.demo5.Child - 【子类】-pool-1-thread-4释放了这个方法，其它线程可以抢了
     *
     *
     * CASE2:(无synchronized)修饰时，执行结果如下：（所有线程一哄而上，侧面说明子类并不会继承父类的synchronized方法，子类若想有父类同样的synchronized的效果，必须显式地在子类的这个方法中加上synchronized关键字才可以）
     * 17:32:57.219 [main] INFO com.example.multithread.demo5.SynchronizedDemo - 结束
     * 17:32:57.220 [pool-1-thread-4] INFO com.example.multithread.demo5.Child - 【子类】-线程名：pool-1-thread-4在占用这个方法，其它线程请等待
     * 17:32:57.220 [pool-1-thread-4] INFO com.example.multithread.demo5.Child - 【子类】-pool-1-thread-4仍然在用.....
     * 17:32:57.220 [pool-1-thread-3] INFO com.example.multithread.demo5.Child - 【子类】-线程名：pool-1-thread-3在占用这个方法，其它线程请等待
     * 17:32:57.220 [pool-1-thread-3] INFO com.example.multithread.demo5.Child - 【子类】-pool-1-thread-3仍然在用.....
     * 17:32:57.220 [pool-1-thread-1] INFO com.example.multithread.demo5.Child - 【子类】-线程名：pool-1-thread-1在占用这个方法，其它线程请等待
     * 17:32:57.220 [pool-1-thread-1] INFO com.example.multithread.demo5.Child - 【子类】-pool-1-thread-1仍然在用.....
     * 17:32:57.220 [pool-1-thread-2] INFO com.example.multithread.demo5.Child - 【子类】-线程名：pool-1-thread-2在占用这个方法，其它线程请等待
     * 17:32:57.221 [pool-1-thread-2] INFO com.example.multithread.demo5.Child - 【子类】-pool-1-thread-2仍然在用.....
     * 17:32:57.221 [pool-1-thread-5] INFO com.example.multithread.demo5.Child - 【子类】-线程名：pool-1-thread-5在占用这个方法，其它线程请等待
     * 17:32:57.221 [pool-1-thread-5] INFO com.example.multithread.demo5.Child - 【子类】-pool-1-thread-5仍然在用.....
     * 17:33:07.230 [pool-1-thread-2] INFO com.example.multithread.demo5.Child - 【子类】-pool-1-thread-2释放了这个方法，其它线程可以抢了
     * 17:33:07.230 [pool-1-thread-4] INFO com.example.multithread.demo5.Child - 【子类】-pool-1-thread-4释放了这个方法，其它线程可以抢了
     * 17:33:07.230 [pool-1-thread-3] INFO com.example.multithread.demo5.Child - 【子类】-pool-1-thread-3释放了这个方法，其它线程可以抢了
     * 17:33:07.230 [pool-1-thread-5] INFO com.example.multithread.demo5.Child - 【子类】-pool-1-thread-5释放了这个方法，其它线程可以抢了
     * 17:33:07.230 [pool-1-thread-1] INFO com.example.multithread.demo5.Child - 【子类】-pool-1-thread-1释放了这个方法，其它线程可以抢了
     */
}
