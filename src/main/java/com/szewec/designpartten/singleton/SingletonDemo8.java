package com.szewec.designpartten.singleton;

/**
 * 枚举[推荐用]
 * <p>
 * 借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象。
 * 可能是因为枚举在JDK1.5中才添加，所以在实际项目开发中，很少见人这么写过
 */
public enum SingletonDemo8 {
    INSTANCE;

    /*TODO 下述写具体可被调用的实现方法，此处whateverMethod即为这样的方法*/
    public void whateverMethod() {
    }
}
