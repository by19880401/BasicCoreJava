package com.example.threadpool;

import java.util.UUID;

/**
 * 当用于在页面快速不停地点击10次“同步”按钮时，前端页面会发出10次相同的同步请求，当一个任务在后端执行同步操作并且未完成时，另外一个线程同样会执行同步操作而系统毫无阻拦，这样会造成系统资源被无情消耗，
 * 应该在任务执行时，对下次将要执行的相同的任务做阻拦，避免桢的任务反复重、重复地执行
 */
public class ThreadDemo {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {//此处理模块页面点击，假如页面连续点击10次，便会迅速创建出10个线程
            System.out.println("crate the new thread, No." + i + "time......");
            new Thread(() -> {
                // demo
                String contractId = UUID.randomUUID().toString() ;//10个线程，每个都会创建1个UUID
                System.out.println("*******************创建UUID：" +contractId);//UUID用于标记任务
                test(contractId);
            }).start();
        }
    }

    private static void test(String contractId) {
        try {//10个任务会依次休眠5秒（每个任务都会休眠5秒）
            Thread.sleep(5000);
            System.out.println("*******************sleep UUID：" +contractId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }//任务醒来之后，继续执行
        System.out.println("*******************wake up UUID：" + contractId);
    }
}
