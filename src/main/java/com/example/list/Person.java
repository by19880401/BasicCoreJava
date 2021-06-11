package com.example.list;

/**
 * @author qianyy
 */
public class Person {
    private Integer id;
    private String name;
    private String age;
    private int year;
    private int month;

    public Person() {
    }

    public Person(Integer id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person(Integer id, String name, String age, int year, int month) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.year = year;
        this.month = month;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", year=" + year +
                ", month=" + month +
                '}';
    }
}
