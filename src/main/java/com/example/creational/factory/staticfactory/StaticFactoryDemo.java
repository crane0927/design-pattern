package com.example.creational.factory.staticfactory;

/**
 * 静态工厂 demo
 */
public class StaticFactoryDemo {

    public static void main(String[] args) {
        Coffee latte = CoffeeStaticFactory.create("latte");
        Coffee americano = CoffeeStaticFactory.create("americano");
        System.out.println(latte.name());
        System.out.println(americano.name());
    }
}
