package com.example.creational.factory.abstract_factory;

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
