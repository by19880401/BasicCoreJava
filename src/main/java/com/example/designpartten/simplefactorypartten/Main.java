package com.example.designpartten.simplefactorypartten;

/**
 * 测试-简单工厂类
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/11
 * @
 */
public class Main {
    public static void main(String[] args) {
        ProductCar productCar = SimpleCarFactory.getProductCar(/*CarEnum.POLICE_CAR*//*CarEnum.BUS*/CarEnum.TRUCK);
        productCar.run();
    }
}
