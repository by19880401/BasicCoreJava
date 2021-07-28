package com.example.lambda;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author baiyang
 * @date 2021/6/15
 */
@ToString
@Data
public class Person {
    private String id;
    private String name;
    private Integer year;
    private Integer month;
    private Date planStart;
    private Date planEnd;

    public Person() {
    }

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
