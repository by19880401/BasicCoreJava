package com.beijingwujian.log;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * 支持的文件类型
 */
@ToString
@AllArgsConstructor // 由于枚举类的构造方法强制为私有，所以@AllArgsConstructor不需要使用access = AccessLevel.PRIVATE
public enum FileType {
    MARKDOWN(".md"), TEXT(".txt");

    private final String suffix;//拿掉setter，直接暴露属性，将属性改成final确保不会被篡改
}
