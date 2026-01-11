package com.example.creational.factory.abstract_factory;

/**
 * 抽象工厂 demo
 */
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        CafeFactory starbucks = new StarbucksFactory(); // 星巴克
        CafeFactory luckin = new LuckinFactory(); // 瑞幸

        printSet("Starbucks", starbucks);
        printSet("Luckin", luckin);
    }

    private static void printSet(String brand, CafeFactory factory) {
        Coffee coffee = factory.createCoffee();
        Cup cup = factory.createCup();
        Sugar sugar = factory.createSugar();
        System.out.println(brand + " -> " + coffee.name() + ", " + cup.material() + ", " + sugar.type());
    }
}
