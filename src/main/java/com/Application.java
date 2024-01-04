package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这其实是一个SpringBoot项目，但我按照Java Client项目在使
 */
@SpringBootApplication
@RestController
public class Application {
    public static void main(String [] args){
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/index")
    String index() {
        return "Hello World, it's a demo service.";
    }
}
