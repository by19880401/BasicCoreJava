package com.schedule;

import com.common.SystemUtils;
import com.web.configuration.ApplicationYamlBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * 定时任务：用来统计日志的数量，并在控制台打印
 *
 * @author Willis Bai
 * @Date 2024-01-19
 */
@Slf4j
@Component //此处，必须有@Component注解，否则无法使用@Autowired注解
public class LogQtyCountTask {

    // 获取yaml文件内容之方法一（如下，可行）
    /*@Value("${enable.logqtycounttask}")
    private Boolean enableTask;*/

    // 获取yaml文件内容之方法二（如下，可行）,官方推荐
    private ApplicationYamlBean applicationYamlBean;

    private SchedulerConfiguration schedulerConfiguration;

    @Autowired
    public void setApplicationYamlBean(ApplicationYamlBean applicationYamlBean) {
        this.applicationYamlBean = applicationYamlBean;
    }

    @Autowired
    public void setSchedulerConfiguration(SchedulerConfiguration schedulerConfiguration) {
        this.schedulerConfiguration = schedulerConfiguration;
    }

    @Scheduled(cron = "*/5 * * * * ?")//每5秒执行一次
//    @Scheduled(initialDelay = 10000, fixedRate = 10000) //容器启动后,延迟10秒后再执行一次定时器,以后每10秒再执行一次该定时器
    public void countLog() {
        // 检查任务开关是否开启
        if (!isScheduledTaskOpen()) {
            return;
        }
        int fileNum = 0; // 文件数量
        int directoryNum = 0; //目录数量
        String filePath = findFilePathForDifferentOS();
        File file = new File(filePath);
        if (!file.isDirectory()) {
            // 判断目录是否存在
            log.info("Directory doesn't exist");
            return;
        }
        // 获取该目录下所有的文件
        String[] fileArray = file.list();
        if (ArrayUtils.isEmpty(fileArray)) return;
        for (String item : fileArray) {
            File fileItem = new File(file + File.separator + item);
            if (fileItem.isFile()) fileNum++;
            if (fileItem.isDirectory()) directoryNum++;
        }
        log.info("File num: {}, directory num: {}", fileNum, directoryNum);
    }

    private String findFilePathForDifferentOS() {
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
     * 读取yaml文件中的开关值
     *
     * @return true: open; false: closed
     */
    private boolean isScheduledTaskOpen() {
        boolean enabled = schedulerConfiguration.getEnableLogQtyCountTask();
        log.info("The task is: {}", (enabled ? "Enabled" : "Disabled"));
        return enabled;
    }
}
