package com.beijingwujian;

import cn.hutool.log.StaticLog;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class JavaLogDemo {

    private static Map<String, Object> yamlMap = null;//yaml配置

    static {
        YamlMapFactoryBean yamlMapFactoryBean = new YamlMapFactoryBean();
        yamlMapFactoryBean.setResources(new ClassPathResource("application.yml"));
        yamlMap = yamlMapFactoryBean.getObject();
    }

    /**
     * 主函数，每天执行它
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        yamlMap.keySet().forEach(item->{

        });

        // 获取当前时间
        String currentDate = getCurrentTimeStr();
        // 把当前时间作为参数，获取当天的日志markdown文件
        ClassPathResource resource = new ClassPathResource("/log/" + currentDate + ".md");
        // TODO 考虑根据不同的操作系统来读取或者创建日志路径！
        ClassPathResource resource = new ClassPathResource("/log/" + currentDate + "1.md");
        try {
//            if (!resource.exists()) {
//                StaticLog.info("MD file doesn't exist, start to create it.");
//                String filePath = resource.getPath();
//                URL path = ClassLoader.getSystemResource(filePath);
//                StaticLog.info(path.getPath());
//            }

            // 获取MD文件
            String filePath = resource.getFile().getPath();
            // 读取MD文件
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            // 一行一行遍历文件内容，打印
            for (String line : lines) {
                StaticLog.info(line);
            }
        } catch (IOException e) {
            // 如果发生异常，打印异常信息
            StaticLog.warn("some errors occur: {}", e.getMessage());
        }
    }

    /**
     * 格式化（当前）时间
     *
     * @return 返回string类型的结果，如果2023-12-21
     */
    private static String getCurrentTimeStr() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dtf.format(LocalDateTime.now());
    }
}
