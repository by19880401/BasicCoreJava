package com.beijingwujian.snakeyml;

import cn.hutool.log.StaticLog;
import org.yaml.snakeyaml.Yaml;

/**
 * 在使用SnakeYml解析yml时，最常使用的就是load、loadlAll、loadAs方法，这三个方法可以加载yml文件或字符串，最后返回解析后的对象
 * <p>
 * 演示：loadAll方法
 */
public class Demo2 {
    private static final String APPLICATION_YAML = "application.yml";

    public static void main(String[] args) {
        Yaml applicationYAML = new Yaml();
        Iterable<Object> objects = applicationYAML.loadAll(new Demo2().getClass().getClassLoader().getResourceAsStream(APPLICATION_YAML));
        for (Object object : objects) {
            StaticLog.info("{}", object);
        }

        /**
         * Result:
         * 09:44:29.405 [main] DEBUG cn.hutool.log.LogFactory - Use [Slf4j] Logger As Default.
         * 09:44:29.406 [main] INFO com.beijingwujian.snakeyml.Demo2 - {server={port=5050}, JavaLogDemo={log={windows.filePath=D:\local-repos\BasicCoreJava\src\main\resources\log, macOs.filepath=/Users/willisbai/GitRepo/BasicCoreJava/src/main/resources/log, linux.filepath=null}, file={suffix=.md}}}
         */
    }
}
