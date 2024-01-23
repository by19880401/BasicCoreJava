package com.web.entity;

import lombok.Data;

/**
 * @Author ibaiy
 * @Date 2024/1/23 14:45
 **/
@Data
public class Account {
    private long id;
    private String userName;
    private String role;
    private int age;
    private String description;
}
