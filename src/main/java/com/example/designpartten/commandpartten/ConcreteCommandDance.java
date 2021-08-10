package com.example.designpartten.commandpartten;

/**
 * 具体的命令实现类，实现了抽象命令对象的具体实现
 * 比如，这个命令，是让执行一个【跳舞】的操作
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/10
 * @
 */
public class ConcreteCommandDance implements Command {

    // 执行命令的人，比如电视，电视作为接受者，接到跳舞的命令后，执行换台至跳舞的节目
    private DanceReceiver danceReceiver;

    public ConcreteCommandDance(DanceReceiver danceReceiver) {
        this.danceReceiver = danceReceiver;
    }

    @Override
    public void doExecute() {
        danceReceiver.action();
    }
}
