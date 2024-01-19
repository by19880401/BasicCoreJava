package com.schedule;

import cn.hutool.log.StaticLog;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务：用来统计日志的数量，并在控制台打印
 *
 * @author Willis Bai
 * @Date 2024-01-19
 */
@Component
public class LogQtyCountTask {
    //    @Scheduled(cron = "*/5 * * * * ?")//每5秒执行一次
    @Scheduled(initialDelay = 10000, fixedRate = 10000) //容器启动后,延迟10秒后再执行一次定时器,以后每10秒再执行一次该定时器
    public void countLog() {
        StaticLog.info("hello");
    }
}
