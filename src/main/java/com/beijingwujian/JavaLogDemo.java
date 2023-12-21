package com.beijingwujian;

import cn.hutool.log.StaticLog;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JavaLogDemo {
    public static void main(String[] args) {
        String filePath = "/log/2023-12-21.md";
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                StaticLog.info(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
