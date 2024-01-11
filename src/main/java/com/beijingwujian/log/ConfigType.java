package com.beijingwujian.log;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum ConfigType {
    LOG("log"), FILE("file");//在application.yml里的一级菜单配置

    private final String configType;
}
