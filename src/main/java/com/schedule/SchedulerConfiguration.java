package com.schedule;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * {@code @Author} Willis
 *
 * @Date 2024/1/22 11:24
 **/
@Configuration // 表明这是一个配置类
@ConfigurationProperties(prefix = "schedule", ignoreUnknownFields = false, ignoreInvalidFields = true)
//该注解用于绑定属性。prefix用来选择属性的前缀，也就是在schedule.yml文件中的“schedule”，ignoreUnknownFields是用来告诉SpringBoot在有属性不能匹配到声明的域时抛出异常
@PropertySource(value = "classpath:schedule.yml", factory = SchedulePropertySourceFactory.class)//配置文件路径，配置转换类
@Setter
@Component
public class SchedulerConfiguration {
    @Value("${schedule.enable.log-qty-count-task}")
    private Boolean enableLogQtyCountTask; // 不推荐写法 --> getEnableLogQtyCountTask

    @Value("${schedule.enable.archive-history-file-task}")
    private boolean enableArchiveHistoryFileTask;// 推荐写法--> isEnableArchiveHistoryFileTask

    public Boolean getEnableLogQtyCountTask() {
        return enableLogQtyCountTask;
    }

    public boolean isEnableArchiveHistoryFileTask() {
        return enableArchiveHistoryFileTask;
    }
}
