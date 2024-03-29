package com.beijingwujian;

import com.beijingwujian.snakeyml.ApplicationYaml;
import com.common.SystemUtils;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

/**
 * 解析yaml文件的方式二
 * SnakeYml在使用前需要引入依赖，但是同时也可以脱离Spring环境单独使用
 *
 * @apiNote 时间：2024-01-16
 */
@Slf4j
public class JavaLogDemoCase2 {

    private static final String APPLICATION_YAML = "java-log-demo-case.yml";
    private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";
    private static final ApplicationYaml applicationYaml;

    // 日志文件路径
    private static String filePath = "";


    // 静态块读取日志文件路径配置，只读一次
    static {
        // 读取yaml文件配置，直接赋值给yaml对象，简单干净，缺点是：我需要创建很多的对象来接这些配置值
        Yaml applicationYAML = new Yaml();
//        applicationYaml = applicationYAML.loadAs(new JavaLogDemoCase2().getClass().getClassLoader().getResourceAsStream(APPLICATION_YAML), ApplicationYaml.class);
        applicationYaml = applicationYAML.loadAs(JavaLogDemoCase2.class.getClassLoader().getResourceAsStream(APPLICATION_YAML), ApplicationYaml.class);
        log.info("Configurations({}) is done.", APPLICATION_YAML);
    }

    /**
     * 主函数，每次都执行它
     * <p>
     * TODO 生成和写的日志文件里的内容所有人都可见，考虑加密日志内容，做到只有运行main程序才能看到，其它情况下，只能看到加密后的密文
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        // 如果yaml文件内容是空的（没有任何配置），提示，退出程序
        if (Objects.isNull(applicationYaml)) {
            log.warn("FilePath is not configured for {} in {}", SystemUtils.getOsName(), APPLICATION_YAML);
            return;
        }

        findFilePathForDifferentOs();

        log.info("File suffix is {}", applicationYaml.getDemonstration().getFile().getSuffix());

        // 获取当前时间
        String currentDate = getCurrentTimeStr();
        // 接下来的故事，大家都知道了，参考com/beijingwujian/JavaLogDemoCase1.java
        // 把当前时间作为参数，获取当天的日志MarkDown文件
        List<String> lines = Lists.newArrayList();
        try (InputStream inputStream = JavaLogDemoCase2.class.getResourceAsStream("/log/" + currentDate + ".md")) {
            if (null == inputStream) {
                log.info("File doesn't exist, start to create it.");
                createDirectoryOrFile(currentDate);
                return;
            }
            // 以下是：标准写法; 使用try-with-resources语法糖自动关闭I/O
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String content;
                while ((content = reader.readLine()) != null) {
                    lines.add(content);
                }
            }

        } catch (IOException e) {
            log.warn("Exception: {}", e.getMessage());
        }

        if (CollectionUtils.isEmpty(lines)) {
            log.info("No content found in {}.md file.", currentDate);
            return;
        }
        // 一行一行遍历文件内容，打印
        for (String line : lines) {
            log.info(line);
        }
    }

    /**
     * 格式化（当前）时间
     *
     * @return 返回string类型的结果，如果2023-12-21
     */
    private static String getCurrentTimeStr() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN);
        return dtf.format(LocalDateTime.now());
    }

    private static void createDirectoryOrFile(String currentDate) throws IOException {
        File dir = new File(filePath);
        if (dir.isDirectory()) {
            // 如果是已存在的目录，则直接在该目录下创建日志文件
            File file = new File(filePath + File.separator + currentDate + ".md");
            boolean isCreateFile = file.createNewFile();
            log.info("A new file is created for {} --> {}", currentDate, (isCreateFile ? "Yes" : "No"));
        } else {
            // 如果filePath不存在，则创建该目录（从父目录一直到子目录，全部创建）
            boolean isMkDirs = dir.mkdirs();
            log.info("A new directory is created --> {}", (isMkDirs ? "Yes" : "No"));
        }
    }

    private static void findFilePathForDifferentOs() {
        if (SystemUtils.isWindows()) {
            log.info("It's running on Windows OS");
            filePath = applicationYaml.getDemonstration().getLog().getPath4windows();
        } else if (SystemUtils.isMacOs()) {
            log.info("It's running on Mac OS");
            filePath = applicationYaml.getDemonstration().getLog().getPath4macos();
        } else {
            // unix or linux
            log.info("It's running on Linux or Unix OS");
            filePath = applicationYaml.getDemonstration().getLog().getPath4linux();
        }
        log.info("Current filePath: {}", filePath);
    }
}
