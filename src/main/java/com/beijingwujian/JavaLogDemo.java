package com.beijingwujian;

import cn.hutool.log.StaticLog;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class JavaLogDemo {
    public static void main(String[] args) {
        String currentDate = getCurrentTimeStr();
        ClassPathResource resource = new ClassPathResource("/log/" + currentDate + ".md");
        try {
            String filePath = resource.getFile().getPath();
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                StaticLog.info(line);
            }
        } catch (IOException e) {
            StaticLog.warn("some errors occur: {}", e.getMessage());
        }
    }

    private static String getCurrentTimeStr() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dtf.format(LocalDateTime.now());
    }
}
