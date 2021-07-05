package com.example.uuid;

import org.apache.commons.lang.StringUtils;

import java.util.UUID;

/**
 * @author baiyang
 * @date 2021/7/5
 */
public class UuidDemo {
    public static void main(String[] args) {
        UUID uId = UUID.randomUUID();
        System.out.println(StringUtils.replace(uId.toString(), "-", ""));
    }
}
