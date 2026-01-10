package com.example.factory.abstractfactory;

/**
 * 抽象工厂接口
 */
public interface CafeFactory {
    Coffee createCoffee(); // 创建咖啡

    Cup createCup(); // 创建杯子

    Sugar createSugar(); // 创建糖
}
