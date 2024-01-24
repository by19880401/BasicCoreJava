package com.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public enum DateTimeUtils {
    INSTANCE;

    public String formatCurrentDateTime() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SS").format(LocalDateTime.now());
    }
}
