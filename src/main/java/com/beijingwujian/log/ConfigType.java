package com.beijingwujian.log;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum ConfigType {
    LOG("log"), FILE("file");

    private String configType;
}
