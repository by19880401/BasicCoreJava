package com.example.multithread.demo5;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/9
 * @
 */
public class MyThread extends Child implements Runnable{
    @Override
    public void run() {
//        super.printInfo();
        super.callParentPrintInfo();
    }
}
