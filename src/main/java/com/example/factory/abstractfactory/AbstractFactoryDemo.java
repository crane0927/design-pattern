package com.example.factory.abstractfactory;

/**
 * 抽象工厂 demo
 */
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        CafeFactory starbucks = new StarbucksFactory();
        CafeFactory luckin = new LuckinFactory();

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
