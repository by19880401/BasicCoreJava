package com.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 定时任务，每天执行一次，对历史日志文件归档
 * <p>
 * {@code @Author} Willis
 *
 * @Date 2024/1/22 10:00
 **/
@Slf4j
@Component
public class ArchiveHistoryFileTask {

    private SchedulerConfiguration schedulerConfiguration;

    @Autowired
    public void setSchedulerConfiguration(SchedulerConfiguration schedulerConfiguration) {
        this.schedulerConfiguration = schedulerConfiguration;
    }

    @Scheduled(initialDelay = 5000, fixedRate = 1000) //容器启动后,延迟5秒后再执行一次定时器,以后每1秒再执行一次该定时器
    public void archiveHistoryFile() {
        // 检查任务开关是否开启
        if (!isScheduledTaskOpen()) {
            return;
        }
        // HH：代表24小时制的小时，hh：代表12小时制的小时
        log.info("Task is running.");
    }

    /**
     * 2024-01-22 16:00:00.001 INFO  com.schedule.LogQtyCountTask -
     * 2024-01-22 16:00:00.010 INFO  com.schedule.LogQtyCountTask - The task is: Disabled at 2024-01-22 16:00:00.00
     *
     * @return
     */
    private boolean isScheduledTaskOpen() {
        boolean enabled = schedulerConfiguration.isEnableArchiveHistoryFileTask();
        log.info("The task is: {}", (enabled ? "Enabled" : "Disabled"));
        return enabled;
    }
}
