package com.schedule;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务，每天执行一次，对历史日志文件归档
 *
 * {@code @Author} Willis
 * @Date 2024/1/22 10:00
 **/
public class ArchiveHistoryFileTask {

    @Scheduled(cron = "*/5 * * * * ?")
    public void archiveHistoryFile(){
        //
    }
}
