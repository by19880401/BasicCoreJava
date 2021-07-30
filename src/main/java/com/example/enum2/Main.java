package com.example.enum2;

import cn.hutool.log.StaticLog;

/**
 * 如果枚举不添加任何方法，枚举值默认为从0开始的有序数值
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/7/30
 * @
 */
public class Main {
    public static void main(String[] args) {
        StaticLog.info("-->{}", ResultStatusEnum.SUCCESS.ordinal());
        StaticLog.info("-->{}", ResultStatusEnum.FILED.ordinal());
        StaticLog.info("-->{}", ResultStatusEnum.PROCESSED.ordinal());
    }
}
