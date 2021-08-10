package com.example.designpartten.commandpartten;

/**
 * 抽象出命令接口，不同的命令类型，使用同一命令接口，写出不同的实现类
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/10
 * @
 */
public interface Command {
    void doExecute();
}
