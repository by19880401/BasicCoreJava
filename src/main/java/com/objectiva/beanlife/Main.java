package com.objectiva.beanlife;


/**
 * 类的五大成员：属性、方法、构造器、代码块、内部类
 * 代码执行顺序:
 * (1) 先加载类, a加载父类: 父类的静态(静态属性, 静态方法, 静态代码块)
 *
 *
 */
public class Main {
    /**
     * 测试结果, 如下:
     * [2022-06-09 16:00:23] [INFO] beanlife.ParentBean: ParentBean : 静态代码块
     * [2022-06-09 16:00:23] [INFO] beanlife.ParentBean: ParentBean : staticAttribute : 100
     * [2022-06-09 16:00:23] [INFO] beanlife.ChildBean: ChildBean : 静态代码块
     * [2022-06-09 16:00:23] [INFO] beanlife.ChildBean: ChildBean : staticAttribute : 200
     * [2022-06-09 16:00:23] [INFO] beanlife.ParentBean: ParentBean : 普通代码块
     * [2022-06-09 16:00:23] [INFO] beanlife.ParentBean: ParentBean : attribute : 101
     * [2022-06-09 16:00:23] [INFO] beanlife.ParentBean: ParentBean : 无参构造方法
     * [2022-06-09 16:00:23] [INFO] beanlife.ChildBean: ChildBean : 普通代码块
     * [2022-06-09 16:00:23] [INFO] beanlife.ChildBean: ChildBean : attribute : 201
     * [2022-06-09 16:00:23] [INFO] beanlife.ChildBean: ChildBean : 无参构造方法
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        // 创建子类对象
        new ChildBean();
    }
}
