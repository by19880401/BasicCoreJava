package com.objectiva.string;

import cn.hutool.log.StaticLog;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<String> list = Arrays.asList("1", "2", "3", "4", "5");
        for (String str : list) {
            sb.insert(0, "/" + str);
        }

        StaticLog.info(sb.toString());

        StringJoiner sj = new StringJoiner("/");
        for (String str : list) {
            sj.add(str);
        }
        StringJoiner js2 = new StringJoiner("/");
        js2.add("7");
        js2.merge(sj);
        StaticLog.info(js2.toString());
    }
}
