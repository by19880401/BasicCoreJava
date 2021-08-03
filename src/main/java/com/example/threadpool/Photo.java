package com.example.threadpool;

import lombok.ToString;

/**
 * @author baiyang
 * @date 2021/6/16
 */
@ToString
public class Photo {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
