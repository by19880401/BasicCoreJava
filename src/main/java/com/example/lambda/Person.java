package com.example.lambda;

/**
 * @author baiyang
 * @date 2021/6/15
 */
public class Person {
    private String id;
    private Integer year;
    private Integer month;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Person{" + "id='" + id + '\'' + ", year=" + year + ", month=" + month + '}';
    }
}
