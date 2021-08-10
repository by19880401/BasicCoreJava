package com.example.designpartten.commandpartten;

/**
 * 请求者/调用者：发起执行命令请求的对象
 * 比如，这里Invoker是遥控器，遥控器对电视发出换台的命令
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/10
 * @
 */
public class Invoker {
    // 命令
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    // 请求者/调用者，调用命令对象执行命令
    public void call() {
        command.doExecute();
    }
}
