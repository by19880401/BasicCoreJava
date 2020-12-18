package com.szewec.designpartten.singleton;

/**
 * 双重检查[推荐用]
 * <p>
 * Double-Check概念对于多线程开发者来说不会陌生，
 * 如代码中所示，我们进行了两次if (singleton == null)检查，这样就可以保证线程安全了。
 * 这样，实例化代码只用执行一次，后面再次访问时，判断if (singleton == null)，
 * 直接return实例化对象。
 * <p>
 * 优点：线程安全；延迟加载；效率较高
 */
public class SingletonDemo6 {
    // volatile在多线程中的作用是：当singleton的值变化时，可以立即让所有线程知道singleton的最新值
    private static volatile SingletonDemo6 singleton;

    private SingletonDemo6() {
    }

    public static SingletonDemo6 getInstance() {
        if (singleton == null) {//两个线程会同时进入到这里
            synchronized (SingletonDemo6.class) {//synchronized的加持，只允许其中一个线程进入
                if (singleton == null) {//双重检查，为空时，创建一个实例，当此实例被创建后，由于volatile的修饰，它可以立即被其它线程得到；其它线程走到这里时，已经知道有实例被创建了，所以会因条件直接返回该实例
                    singleton = new SingletonDemo6();
                }
            }
        }
        return singleton;
    }

    /*TODO 下述写具体可被调用的实现方法*/
}
