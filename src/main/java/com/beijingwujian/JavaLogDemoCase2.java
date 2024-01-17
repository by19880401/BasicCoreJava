package com.beijingwujian;

import cn.hutool.log.StaticLog;
import com.beijingwujian.snakeyml.ApplicationYaml;
import com.common.SystemUtils;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

/**
 * SnakeYml在使用前需要引入依赖，但是同时也可以脱离Spring环境单独使用
 *
 * @Date 2024-01-16
 */
public class JavaLogDemoCase2 {

    private static final String APPLICATION_YAML = "application.yml";
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
            StaticLog.warn("filePath is not configured for {} in {}", SystemUtils.getOsName(), APPLICATION_YAML);
            return;
        }
        if (SystemUtils.isWindows()) {
            StaticLog.info("It's running on Windows OS");
            filePath = applicationYaml.getJavaLogDemo().getLog().getWindows_file_path();
        } else if (SystemUtils.isMacOs()) {
            StaticLog.info("It's running on Mac OS");
            filePath = applicationYaml.getJavaLogDemo().getLog().getMacOs_file_path();
        } else {
            // unix or linux
            StaticLog.info("It's running on Linux or Unix OS");
            filePath = applicationYaml.getJavaLogDemo().getLog().getLinux_file_path();
        }

        StaticLog.info("current filePath: {}", filePath);

        // 获取当前时间
        String currentDate = getCurrentTimeStr();
        // 接下来的故事，大家都知道了，参考com/beijingwujian/JavaLogDemoCase1.java
        // 把当前时间作为参数，获取当天的日志MarkDown文件
        InputStream inputStream = JavaLogDemoCase2.class.getResourceAsStream("/log/" + currentDate + ".md");
        try {
            if (null == inputStream) {
                StaticLog.info("file doesn't exist, start to create it.");
                createDirectoryOrFile(currentDate);
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            List<String> lines = Lists.newArrayList();
            String content;
            while ((content = reader.readLine()) != null) {
                lines.add(content);
            }

            if (CollectionUtils.isEmpty(lines)) {
                StaticLog.info("no content found in {}.md file.", currentDate);
                return;
            }
            // 一行一行遍历文件内容，打印
            for (String line : lines) {
                StaticLog.info(line);
            }

        } catch (IOException e) {
            StaticLog.warn("exception: {}", e.getMessage());
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
            StaticLog.info("a new file is created for {} --> {}", currentDate, (isCreateFile ? "Yes" : "No"));
        } else {
            // 如果filePath不存在，则创建该目录（从父目录一直到子目录，全部创建）
            boolean isMkDirs = dir.mkdirs();
            StaticLog.info("a new directory is created --> {}", (isMkDirs ? "Yes" : "No"));
        }
    }
}
