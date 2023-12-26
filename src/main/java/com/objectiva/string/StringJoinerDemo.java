package com.objectiva.string;

import cn.hutool.log.StaticLog;

import java.util.StringJoiner;

public class StringJoinerDemo {
    public static void main(String[] args) {
        StringJoiner s1 = new StringJoiner("/");
        s1.add("a");
        s1.add("b");
        StringJoiner s2;
        s2 = s1;
        StaticLog.info("{} {}", s1,s2);
    }
}
