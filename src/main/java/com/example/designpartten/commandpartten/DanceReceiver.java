package com.example.designpartten.commandpartten;

import cn.hutool.log.StaticLog;

/**
 * 接收者（即电视），真正接受并执行命令的对象
 * 这里执行者接到【跳舞的命令】后，开始【跳舞】的动作
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/10
 * @
 */
public class DanceReceiver {
    public void action() {
        StaticLog.info("Dance....dong,dong,dong.....");
    }
}
