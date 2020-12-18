package com.szewec.designpartten.singleton;

/**
 * 饿汉式（静态代码块）[可用]
 * <p>
 * 这种方式和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。优缺点和第一种写法是一样的
 */
public class SingletonDemo2 {
    private static SingletonDemo2 instance;

    static {
        instance = new SingletonDemo2();
    }

    private SingletonDemo2() {
    }

    public static SingletonDemo2 getInstance() {
        return instance;
    }

    /*TODO 下述写具体可被调用的实现方法*/
}
