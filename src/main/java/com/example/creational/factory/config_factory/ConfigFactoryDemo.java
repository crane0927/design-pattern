package com.example.creational.factory.config_factory;

public class ConfigFactoryDemo {
    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.getCoffee("latte");
        System.out.println(coffee);
        System.out.println(coffee.name());

        Coffee coffee2 = CoffeeFactory.getCoffee("latte");
        System.out.println(coffee == coffee2); // true 这这种方式获取的是单例

        Coffee coffee3 = CoffeeFactory.getCoffee("americano");
        System.out.println(coffee3);
        System.out.println(coffee3.name());

    }

}
