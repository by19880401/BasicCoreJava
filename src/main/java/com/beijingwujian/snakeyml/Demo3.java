package com.beijingwujian.snakeyml;

import cn.hutool.log.StaticLog;
import org.yaml.snakeyaml.Yaml;

/**
 * 在使用SnakeYml解析yml时，最常使用的就是load、loadAll、loadAs方法，这三个方法可以加载yml文件或字符串，最后返回解析后的对象
 * <p>
 * 演示：loadAs方法
 */
public class Demo3 {
    private static final String APPLICATION_YAML = "application.yml";

    /**
     *
     * Result:
     * 09:59:14.575 [main] DEBUG cn.hutool.log.LogFactory - Use [Slf4j] Logger As Default.
     * 09:59:14.576 [main] INFO com.beijingwujian.snakeyml.Demo3 - ApplicationYaml(server=TomcatServer(port=5050), javaLogDemo=JavaLogDemo(log=Log(windowsFilePath=D:\local-repos\BasicCoreJava\src\main\resources\log, macOsFilepath=/Users/willisbai/GitRepo/BasicCoreJava/src/main/resources/log, linuxFilepath=null), file=File(suffix=.md)))
     */
    public static void main(String[] args) {
        Yaml applicationYAML = new Yaml();
        ApplicationYaml applicationYaml = applicationYAML.loadAs(Demo3.class.getClassLoader().getResourceAsStream(APPLICATION_YAML), ApplicationYaml.class);
        StaticLog.info("{}", applicationYaml);
    }
}
