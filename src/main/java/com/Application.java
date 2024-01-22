package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这其实是一个SpringBoot项目，但我按照Java Client项目在使
 */
//@EnableScheduling // 开启定时任务（可行，但有另外一种更灵活的配置方式，详见yaml文件中enable.scheduling）
@SpringBootApplication
@RestController // 由于下方使用@RequestMapping("/index")以允许通过URL访问，所以这里使用@RestController来标明这是一个controller
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/index1")
    String index() {
        return "Hello World, it's an amazing demonstration service.";
    }
}
