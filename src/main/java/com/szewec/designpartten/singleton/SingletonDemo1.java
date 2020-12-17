package com.szewec.designpartten.singleton;
/**
 * 单例模式在多线程的应用场合下必须小心使用。如果当唯一实例尚未创建时，有两个线程同时调用创建方法，
 * 那么它们同时没有检测到唯一实例的存在，从而同时各自创建了一个实例，这样就有两个实例被构造出来，
 * 从而违反了单例模式中实例唯一的原则。 解决这个问题的办法是为指示类是否已经实例化的变量提供一个互斥锁(虽然这样会降低效率)
 */

/**
 * 饿汉式（静态常量）[可用]
 *
 * 优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
 *
 * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费
 *
 */
public class SingletonDemo1 {
    private final static SingletonDemo1 INSTANCE = new SingletonDemo1();

    private SingletonDemo1() {
    }

    public static SingletonDemo1 getInstance() {
        return INSTANCE;
    }

    /*TODO 下述写具体可被调用的实现方法*/

}
