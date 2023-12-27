package com.common;

/**
 * 该工具类的主要目的是消除以下警告消息：
 * Unchecked cast: 'java.lang.Object' to 'java.util.LinkedHashMap<java.lang.String,java.lang.Object>'
 */
public final class CastUtils {

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object obj) {
        return (T) obj;
    }

    private CastUtils() {
        throw new UnsupportedOperationException();
    }

}
