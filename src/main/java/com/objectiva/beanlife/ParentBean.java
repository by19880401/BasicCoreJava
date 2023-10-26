package com.objectiva.beanlife;

import cn.hutool.log.StaticLog;

/**
 * 父类
 */
public class ParentBean {

    // 静态代码块
    static {
        StaticLog.info("ParentBean : 静态代码块");
    }

    // 普通代码块
    {
        StaticLog.info("ParentBean : 普通代码块");
    }

    // 静态属性的初始化
    private static int staticAttribute = getInitValueForStaticAttribute();

    // 普通属性的初始化
    private int attribute = getInitValueForAttribute();

    // 构造器
    public ParentBean() {
        StaticLog.info("ParentBean : 无参构造方法");
    }

    private static int getInitValueForStaticAttribute() {
        StaticLog.info("ParentBean : staticAttribute : 100");
        return 100;
    }

    private int getInitValueForAttribute() {
        StaticLog.info("ParentBean : attribute : 101");
        return 101;
    }


}
