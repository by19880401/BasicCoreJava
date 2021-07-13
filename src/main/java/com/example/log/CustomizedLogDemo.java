package com.example.log;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.log.dialect.jdk.JdkLogFactory;

/**
 * 自定义log 自定义当前日志门面的日志实现类。当引入多个日志框架时，我们希望自定义所用的日志框架，调用此方法即可。需要注意的是，此方法为全局方法，在获取Log对象前只调用一次即可。
 * @author baiyang
 * @date 2021/7/13
 */
public class CustomizedLogDemo {
    public static void main(String[] args) {
        LogFactory logFactory = LogFactory.setCurrentLogFactory(new JdkLogFactory());
        Log log = logFactory.getLog(CustomizedLogDemo.class);
        log.info("this is the demo for {}", "自定义LOG日志");
    }
}
