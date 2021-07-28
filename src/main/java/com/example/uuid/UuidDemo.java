package com.example.uuid;

import cn.hutool.log.StaticLog;
import org.apache.commons.lang.StringUtils;

import java.util.UUID;

/**
 * 生成UUID
 * @author baiyang
 * @date 2021/7/5
 */
public class UuidDemo {
    public static void main(String[] args) {
        UUID uId = UUID.randomUUID();
        System.out.println(StringUtils.replace(uId.toString(), "-", ""));

        // hutool UUID
        cn.hutool.core.lang.UUID randomUId = cn.hutool.core.lang.UUID.randomUUID();
        cn.hutool.core.lang.UUID fastUid = cn.hutool.core.lang.UUID.fastUUID();
        StaticLog.info("randomUId:{},fastUId={}", randomUId, fastUid);
        /**
         * randomUId:8694d660-b9d1-48d3-b8bb-3a5ae207aae5,
         * fastUId=151e53bc-c399-44bc-b770-a02974b0a830
         */

    }
}
