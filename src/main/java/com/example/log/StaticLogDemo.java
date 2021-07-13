package com.example.log;

import cn.hutool.log.StaticLog;

/**
 * 很多时候，我们只是想简简单的使用日志，最好一个方法搞定，我也不想创建Log对象，那么StaticLog或许是你需要的
 * 同样StaticLog提供了trace、debug、info、warn、error方法，提供变量占位符支持，使项目中日志的使用简单到没朋友。
 * StaticLog类中同样提供log方法，可能在极致简洁的状况下，提供非常棒的灵活性（打印日志等级由level参数决定）
 * @author baiyang
 * @date 2021/7/13
 */
public class StaticLogDemo {

    public static void main(String[] args) {
        String str = "static log";
        StaticLog.info("This is a demo for {}", str);
    }
}
