package com.szewec.designpartten.singleton;

/**
 * 懒汉式(线程安全，同步代码块)[不可用]
 * <p>
 * 由于第四种实现方式同步效率太低，所以摒弃同步方法，
 * 改为同步产生实例化的的代码块。
 * 但是这种同步并不能起到线程同步的作用。跟demo3的实现方式遇到的情形一致，
 * 假如一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，
 * 另一个线程也通过了这个判断语句，这时便会产生多个实例
 */
public class SingletonDemo5 {

    private static SingletonDemo5 singleton;

    private SingletonDemo5() {
    }

    public static SingletonDemo5 getInstance() {
        if (singleton == null) {//此处多线程会进入
            synchronized (SingletonDemo5.class) {
                singleton = new SingletonDemo5();
            }
        }
        return singleton;
    }

    /*TODO 下述写具体可被调用的实现方法*/
}
