package com.schedule;

import cn.hutool.log.StaticLog;
import com.common.SystemUtils;
import com.web.configuration.ApplicationYamlBean;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * 定时任务：用来统计日志的数量，并在控制台打印
 *
 * @author Willis Bai
 * @Date 2024-01-19
 */
@Component //此处，必须有@Component注解，否则无法使用@Autowired注解
public class LogQtyCountTask {

    // 获取yaml文件内容之方法一（如下，可行）
    @Value("${demonstration.log.path4windows}")
    private String filePath;

    // 获取yaml文件内容之方法二（如下，可行）,官方推荐
    private ApplicationYamlBean applicationYamlBean;

    @Autowired
    public void setApplicationYamlBean(ApplicationYamlBean applicationYamlBean) {
        this.applicationYamlBean = applicationYamlBean;
    }

    @Scheduled(cron = "*/5 * * * * ?")//每5秒执行一次
//    @Scheduled(initialDelay = 10000, fixedRate = 10000) //容器启动后,延迟10秒后再执行一次定时器,以后每10秒再执行一次该定时器
    public void countLog() {
        int fileNum = 0; // 文件数量
        int directoryNum = 0; //目录数量
        String filePath = findFilePathForDifferentOS();
        File file = new File(filePath);
        if (!file.isDirectory()) {
            // 判断目录是否存在
            StaticLog.info("Directory doesn't exist");
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
        StaticLog.info("file num: {}, directory num: {}", fileNum, directoryNum);
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
        StaticLog.info("current filePath: {}", filePath);
        return filePath;
    }
}
