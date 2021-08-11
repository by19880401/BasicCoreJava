package com.example.designpartten.simplefactorypartten;

import cn.hutool.log.StaticLog;

/**
 * 具体产品-警车
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/11
 * @
 */
public class ConcreteProductPoliceCar implements ProductCar{
    @Override
    public void run() {
        StaticLog.info("警车-开动");
    }
}
