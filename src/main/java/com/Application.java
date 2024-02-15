package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 这其实是一个SpringBoot项目，但我按照Java Client项目在使
 */
//@EnableScheduling // 开启定时任务（可行，但有另外一种更灵活的配置方式，详见application.yml文件中enable.scheduling）
@SpringBootApplication
@MapperScan(basePackages = "com.web.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
