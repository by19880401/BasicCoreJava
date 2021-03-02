package com.example.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListGroupByDemo {

    public static void main(String [] args){

    }

    public List<String> initStrList() {
        List<String> result = new ArrayList<>();
        result.add("张三");
        result.add("李四");
        result.add("王五");
        result.add("赵六");
        return result;
    }

    public List<Person> initPersonList() {
        return Arrays.asList(new Person(1, "willis", "30"), new Person(2, "lucy", "30"), new Person(3, "lily", "30"));
    }

}
