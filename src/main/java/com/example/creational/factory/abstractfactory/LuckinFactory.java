package com.example.creational.factory.abstractfactory;

/**
 * 瑞幸 Factory.
 */
public class LuckinFactory implements CafeFactory {
    @Override
    public Coffee createCoffee() {
        return new Americano();
    }

    @Override
    public Cup createCup() {
        return new CeramicCup();
    }

    @Override
    public Sugar createSugar() {
        return new BrownSugar();
    }
}
