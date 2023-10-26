package com.objectiva.beanlife;

import cn.hutool.log.StaticLog;

/**
 * 子类
 */
public class ChildBean extends ParentBean {
    // 静态代码块
    static {
        StaticLog.info("ChildBean : 静态代码块");
    }

    // 普通代码块
    {
        StaticLog.info("ChildBean : 普通代码块");
    }

    // 静态属性的初始化
    private static int staticAttribute = getInitValueForStaticAttribute();

    // 普通属性的初始化
    private int attribute = getInitValueForAttribute();

    // 构造器
    public ChildBean() {
        StaticLog.info("ChildBean : 无参构造方法");
    }

    private static int getInitValueForStaticAttribute() {
        StaticLog.info("ChildBean : staticAttribute : 200");
        return 200;
    }

    private int getInitValueForAttribute() {
        StaticLog.info("ChildBean : attribute : 201");
        return 201;
    }
}
