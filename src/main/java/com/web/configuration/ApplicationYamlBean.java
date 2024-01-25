package com.web.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * {@code @Author} Willis
 * @Date 2024/1/19 13:52
 **/
@Component
@ConfigurationProperties(prefix = "demonstration")
@PropertySource(value = "classpath:java-log-demo-case.yml")
@Data
public class ApplicationYamlBean {
    private Log log;

    private File file;
}
