package com.schedule;

import com.common.DateTimeUtils;
import com.common.SystemUtils;
import com.web.configuration.ApplicationYamlBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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

    private ApplicationYamlBean applicationYamlBean;

    @Autowired
    public void setApplicationYamlBean(ApplicationYamlBean applicationYamlBean) {
        this.applicationYamlBean = applicationYamlBean;
    }

    private SchedulerConfiguration schedulerConfiguration;

    @Autowired
    public void setSchedulerConfiguration(SchedulerConfiguration schedulerConfiguration) {
        this.schedulerConfiguration = schedulerConfiguration;
    }

    @Scheduled(initialDelay = 5000, fixedRate = 30000) //容器启动后,延迟5秒后再执行一次定时器,以后每30秒再执行一次该定时器
    public void archiveHistoryFile() {
        // 检查任务开关是否开启
        if (!isScheduledTaskOpen()) {
            return;
        }
        log.info("Task is running at {}", DateTimeUtils.INSTANCE.formatCurrentDateTime());
        String filePath = findFilePathForDifferentOS();
        log.info("FilePath: {}", filePath);

    }

    public String findFilePathForDifferentOS() {
        String filePath;
        if (SystemUtils.isWindows()) {
            filePath = applicationYamlBean.getLog().getPath4windows();
        } else if (SystemUtils.isMacOs()) {
            filePath = applicationYamlBean.getLog().getPath4macos();
        } else {
            filePath = applicationYamlBean.getLog().getPath4linux();
        }
        log.info("Current filePath: {}", filePath);
        return filePath;
    }

    /**
     * 任务是否开启
     *
     * @return true: open; false: closed
     */
    private boolean isScheduledTaskOpen() {
        boolean enabled = schedulerConfiguration.isEnableArchiveHistoryFileTask();
        log.info("The task is: {}", (enabled ? "Enabled" : "Disabled"));
        return enabled;
    }
}
