package com.beijingwujian.objnotnull;

import cn.hutool.log.StaticLog;

import java.util.Objects;

public class ObjectNonNullDemo {

    public static void main(String[] args) {
        StaticLog.info("{}", Objects.requireNonNull(null));
    }
}
