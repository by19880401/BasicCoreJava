package com.example.designpartten.simplefactorypartten;

/**
 * 简单工厂类（必须是静态的）
 * 在简单工厂模式中创建实例的方法通常为静态（static）方法，因此简单工厂模式（Simple Factory Pattern）又叫作静态工厂方法模式（Static Factory Method Pattern）
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/11
 * @
 */
public class SimpleCarFactory {
    public static ProductCar getProductCar(CarEnum carTypeEnum) {
        switch (carTypeEnum) {
            case BUS:
                return new ConcreteProductBus();
            case POLICE_CAR:
                return new ConcreteProductPoliceCar();
            case TRUCK:
                return new ConcreteProductTruck();
            default:
                return null;
        }
    }
}
