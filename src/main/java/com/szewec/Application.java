package com.szewec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
