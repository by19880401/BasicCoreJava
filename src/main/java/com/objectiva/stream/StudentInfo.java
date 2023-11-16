package com.objectiva.stream;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class StudentInfo {
    //名称
    private String name;

    //性别 true男 false女
    private Boolean gender;

    //年龄
    private Integer age;

    //身高
    private Double height;

    //出生日期
    private LocalDate birthday;

    public StudentInfo(String name, Boolean gender, Integer age, Double height, LocalDate birthday) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.birthday = birthday;
    }

    public static void printStudentInfo(List<StudentInfo> studentInfoList) {
        System.out.println("[姓名]\t\t[性别]\t\t[年龄]\t\t[身高]\t\t[生日]");
        System.out.println("----------------------------------------------------------");
        studentInfoList.forEach(s -> System.out.println(s.toString()));
        System.out.println(" ");
    }
}
