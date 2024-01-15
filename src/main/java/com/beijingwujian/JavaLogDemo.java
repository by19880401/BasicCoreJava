package com.beijingwujian;

import cn.hutool.log.StaticLog;
import com.common.CastUtils;
import com.common.SystemUtils;
import org.apache.commons.lang3.StringUtils;
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
import java.util.Optional;
import java.util.stream.Collectors;

public class JavaLogDemo {

    private static final String APPLICATION_YAML = "application.yml";
    private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";
    private static final String FILE_PATH_FOR_WINDOWS = "windows.filePath";
    private static final String CONFIG_TYPE_FILE_IN_YAML = "file";
    private static final String CONFIG_TYPE_LOG_IN_YAML = "log";
    private static final String FILE_PATH_FOR_MAC = "macOs.filepath";
    private static final String FILE_PATH_FOR_LINUX = "linux.filepath";
    private static final String FILE_SUFFIX = "suffix";

    // 日志文件路径
    private static String filePath = "";
    private static String fileSuffix = "";

    // 静态块读取日志文件路径配置，只读一次
    static {
        // 读取yaml文件配置
        YamlMapFactoryBean yamlMapFactoryBean = new YamlMapFactoryBean();
        yamlMapFactoryBean.setResources(new ClassPathResource(APPLICATION_YAML));
        // 通过getObject()方法获取Map对象
        Map<String, Object> yamlMap = yamlMapFactoryBean.getObject();
        readFilePathInYAML(yamlMap);
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
        if (!isFilePathConfiguredInYAML()) {
            StaticLog.warn("filePath is not configured for {} in {}", SystemUtils.getOsName(), APPLICATION_YAML);
            return;
        }
        StaticLog.info("current filePath: {}", filePath);// TODO windows测试通过，Mac OS测试通过，测试结果见项目README.md
        // 获取当前时间
        String currentDate = getCurrentTimeStr();
        // 把当前时间作为参数，获取当天的日志markdown文件
        ClassPathResource resource = new ClassPathResource("/log/" + currentDate + ".md");
        try {
            // 如果不存在当天的日志文件，则创建它
            if (!resource.exists()) {
                StaticLog.info("file doesn't exist, start to create it.");
                createDirectoryOrFile(resource, currentDate);
                return;
            }

            StaticLog.info("file has already exist, read it.");
            // 获取文件
            String filePath = resource.getFile().getPath();
            // 读取文件
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            // 如果lines为空，即文件内容为空，则直接退出、提示
            if (CollectionUtils.isEmpty(lines)) {
                StaticLog.info("no content found in {}.md file.", currentDate);
                return;
            }
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN);
        return dtf.format(LocalDateTime.now());
    }

    /**
     * 判断yaml文件里是否配置了指定系统下的日志目录
     *
     * @return true: it's configured; false, it's not configured
     */
    private static boolean isFilePathConfiguredInYAML() {
        return !StringUtils.isBlank(filePath);
    }

    private static void readFilePathInYAML(Map<String, Object> yamlMap) {
        // 如果这是个空的yaml文件，退出程序
        if (CollectionUtils.isEmpty(yamlMap)) {
            StaticLog.warn("no configurations found in {}", APPLICATION_YAML);
            return;
        }
        // 过滤key为“JavaLogDemo”的配置
        Map<String, Object> javaLogDemoMap = yamlMap.entrySet().stream().filter(item -> item.getKey().equals("JavaLogDemo")).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        Optional<Object> javaLogDemoMapValue = javaLogDemoMap.values().stream().findFirst();//名为“JavaLogDemo”节点的，仅有此一个，故只取第一个
        if (!javaLogDemoMapValue.isPresent()) {
            return;
        }
        Map<String, Object> javaLogDemoMapValueMap = CastUtils.cast(javaLogDemoMapValue.get());
        // 遍历key为“JavaLogDemo”的配置
        javaLogDemoMapValueMap.keySet().forEach(item -> {
            switch (item) {
                case CONFIG_TYPE_LOG_IN_YAML:
                    handleFilePath(javaLogDemoMapValueMap, item);
                    break;
                case CONFIG_TYPE_FILE_IN_YAML:
                    handleFileSuffix(javaLogDemoMapValueMap, item);
                    StaticLog.info("File suffix is {}", fileSuffix);
                    break;
                default:
                    // default 分支不需要 break 语句
                    StaticLog.warn("Other configurations are found in {}, ignore...", APPLICATION_YAML);
            }
        });

    }

    private static void handleFilePath(Map<String, Object> yamlMap, String item) {
        // 可以将map中的值强转为LinkedHashMap对象
        LinkedHashMap<String, Object> linkedHashMap = CastUtils.cast(yamlMap.get(item));
        if (SystemUtils.isWindows()) {
            StaticLog.info("It's running on Windows OS");
            filePath = (String) linkedHashMap.get(FILE_PATH_FOR_WINDOWS);
        } else if (SystemUtils.isMacOs()) {
            StaticLog.info("It's running on Mac OS");
            filePath = (String) linkedHashMap.get(FILE_PATH_FOR_MAC);
        } else {
            // unix or linux
            StaticLog.info("It's running on Linux or Unix OS");
            filePath = (String) linkedHashMap.get(FILE_PATH_FOR_LINUX);
        }
    }

    private static void handleFileSuffix(Map<String, Object> yamlMap, String item) {
        LinkedHashMap<String, Object> linkedHashMap = CastUtils.cast(yamlMap.get(item));
        fileSuffix = (String) linkedHashMap.get(FILE_SUFFIX);
    }

    /**
     * 描述：创建目录或者文件本身
     *
     * @param resource    在resource下读取的log文件资源
     * @param currentDate 当前时间
     * @throws IOException 如果有异常，则抛出它
     */
    private static void createDirectoryOrFile(ClassPathResource resource, String currentDate) throws IOException {
        File dir = new File(filePath);
        if (dir.isDirectory()) {
            // 如果是已存在的目录，则直接在该目录下创建日志文件
            File file = new File(filePath + File.separator + resource.getFilename());
            boolean isCreateFile = file.createNewFile();
            StaticLog.info("a new file is created for {} --> {}", currentDate, (isCreateFile ? "Yes" : "No"));
        } else {
            // 创建目录
            boolean isMkDirs = dir.mkdirs();
            StaticLog.info("a new directory is created --> {}", (isMkDirs ? "Yes" : "No"));
        }
    }
}
