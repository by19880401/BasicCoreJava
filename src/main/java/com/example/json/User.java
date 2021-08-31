package com.example.json;

import lombok.ToString;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/31
 * @
 */
@ToString
public class User {
    private Integer id;
    private String name;
    private String password;

    // json转对象时，需要一个空的构造方法，否则会报异常
    public User(){}

    public User(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
