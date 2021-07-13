package com.example.log;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

/**
 * Hutool-log做为一个日志门面，为了兼容各大日志框架，一个用于自动创建日志对象的日志工厂类必不可少
 * 自动识别引入的日志框架，从而创建对应日志框架的门面Log对象（此方法创建一次后，下次再次get会根据传入类名缓存Log对象，对于每个类，Log对象都是单例的），同时自动识别当前类，将当前类做为类名传入日志框架
 * 
 * @author baiyang
 * @date 2021/7/13
 */
public class LogDemo {
    // 推荐创建不可变静态类成员变量
    private static final Log log = LogFactory.get();

    public static void main(String[] args) {
        log.info("This is a demo for {}", "log factory");
    }
}
