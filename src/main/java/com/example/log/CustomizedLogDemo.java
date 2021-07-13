package com.example.log;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.log.dialect.console.ConsoleLogFactory;

/**
 * 自定义log 自定义当前日志门面的日志实现类。当引入多个日志框架时，我们希望自定义所用的日志框架，调用此方法即可。需要注意的是，此方法为全局方法，在获取Log对象前只调用一次即可。
 * 入职【深圳高速顾问有限公司】满一年！！Service date: [2020-07-13]~[2021-07-13]
 * @author baiyang
 * @date 2021/7/13
 */
public class CustomizedLogDemo {
    public static void main(String[] args) {
        // 自定义日志实现为JDK Logging
        /*LogFactory logFactory = LogFactory.setCurrentLogFactory(new JdkLogFactory());*/
        // 自定义日志实现为Apache Commons Logging
        /*LogFactory logFactory = LogFactory.setCurrentLogFactory(new ApacheCommonsLogFactory());*/
        // 自定义日志实现为Console Logging
        LogFactory logFactory = LogFactory.setCurrentLogFactory(new ConsoleLogFactory());
        Log log = logFactory.getLog(CustomizedLogDemo.class);
        log.info("this is the demo for {}", "自定义LOG日志");
    }
}
