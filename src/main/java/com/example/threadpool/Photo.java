package com.example.threadpool;

/**
 * @author baiyang
 * @date 2021/6/16
 */
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

    @Override
    public String toString() {
        return "Photo{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
