package com.beijingwujian.snakeyml;

import cn.hutool.log.StaticLog;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;

/**
 * 在使用SnakeYml解析yml时，最常使用的就是load、loadlAll、loadAs方法，这三个方法可以加载yml文件或字符串，最后返回解析后的对象
 * <p>
 * 演示：load方法
 */
public class Demo1 {
    private static final String APPLICATION_YAML = "application.yml";

    /**
     * Result:
     * 09:39:34.462 [main] DEBUG cn.hutool.log.LogFactory - Use [Slf4j] Logger As Default.
     * 09:39:34.467 [main] INFO com.beijingwujian.snakeyml.Demo1 - {server={port=5050}, JavaLogDemo={log={windows.filePath=D:\local-repos\BasicCoreJava\src\main\resources\log, macOs.filepath=/Users/willisbai/GitRepo/BasicCoreJava/src/main/resources/log, linux.filepath=null}, file={suffix=.md}}}
     */
    public static void main(String[] args) {
        Yaml applicationYAML = new Yaml();
        Map<String, Object> map = applicationYAML.load(Demo1.class.getClassLoader().getResourceAsStream(APPLICATION_YAML));
        StaticLog.info("{}", map);

    }
}
