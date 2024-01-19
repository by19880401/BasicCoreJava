package com.web.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author ibaiy
 * @Date 2024/1/19 13:52
 **/
@Component
@ConfigurationProperties(prefix = "demonstration")
@Data
public class ApplicationYamlBean {
    private Log log;

    private File file;
}
