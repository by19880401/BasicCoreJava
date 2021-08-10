package com.example.designpartten.commandpartten;

/**
 * 测试:相当于我们人类，在这里使用遥控器（Invoker），发出命令（Command），要求电视（SingReceiver/DanceReceiver）换台（sing/dance）
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/10
 * @
 */
public class Main {
    public static void main(String[] args) {
        // 唱歌的命令:发出一个唱歌的命令，要求命令接受者（即电视），换台至唱歌
        Command command = /*new ConcreteCommandSing(new SingReceiver())*/ new ConcreteCommandDance(new DanceReceiver());
        // Invoker是遥控器，把命令给遥控器
        Invoker invoker = new Invoker(command);
        // 遥控器拿到命令后，找电视去换台
        invoker.call();
    }
}
