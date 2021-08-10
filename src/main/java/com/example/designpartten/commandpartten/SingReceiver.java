package com.example.designpartten.commandpartten;

import cn.hutool.log.StaticLog;

/**
 * 接收者，真正接受并执行命令的对象
 * 这里执行者接到唱歌的命令后，开始【唱歌】的动作
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/10
 * @
 */
public class SingReceiver {

    public void action() {
        StaticLog.info("Sing....see you see me.....");
    }

}
