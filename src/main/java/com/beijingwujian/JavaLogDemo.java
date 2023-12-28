package com.beijingwujian;

import cn.hutool.log.StaticLog;
import com.common.CastUtils;
import com.common.SystemUtils;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JavaLogDemo {

    // 日志文件路径
    private static String filePath = "";

    // 静态块读取日志文件路径配置，只读一次
    static {
        // 读取yaml文件配置
        YamlMapFactoryBean yamlMapFactoryBean = new YamlMapFactoryBean();
        yamlMapFactoryBean.setResources(new ClassPathResource("application.yml"));
        // 通过getObject()方法获取Map对象
        Map<String, Object> yamlMap = yamlMapFactoryBean.getObject();
        if (!CollectionUtils.isEmpty(yamlMap)) {
            yamlMap.keySet().forEach(item -> {
                // 可以将map中的值强转为LinkedHashMap对象
                LinkedHashMap<String, Object> linkedHashMap = CastUtils.cast(yamlMap.get(item));
                if (SystemUtils.isWindows()) {
                    StaticLog.info("It's running on Windows OS");
                    filePath = (String) linkedHashMap.get("windows.filePath");
                } else if (SystemUtils.isMacOs()) {
                    StaticLog.info("It's running on Mac OS");
                    filePath = (String) linkedHashMap.get("macOs.filepath");
                } else {
                    // unix or linux
                    StaticLog.info("It's running on Linux or Unix OS");
                    filePath = (String) linkedHashMap.get("linux.filepath");
                }
            });
        }
    }

    /**
     * 主函数，每天执行它
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        StaticLog.info("current filePath: {}", filePath);// TODO windows测试通过，
        // 获取当前时间
        String currentDate = getCurrentTimeStr();
        // 把当前时间作为参数，获取当天的日志markdown文件
        ClassPathResource resource = new ClassPathResource("/log/" + currentDate + ".md");
        try {
            if (!resource.exists()) {
                StaticLog.info("file doesn't exist, start to create it.");
                File dir = new File(filePath);
                if (dir.isDirectory()) {
                    // 如果是已存在的目录，则直接在该目录下创建日志文件
                    File file = new File(filePath + File.separator + resource.getFilename());
                    boolean isCreateFile = file.createNewFile();
                    StaticLog.info("a new file is created [yes or no? -->{}] for {}", isCreateFile, currentDate);
                } else {
                    // 创建目录
                    boolean isMkDirs = dir.mkdirs();
                    StaticLog.info("a new directory is created [yes or no? -->{}].", isMkDirs);
                }
                return;
            }

            StaticLog.info("MD file has already exist, read it.");
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
