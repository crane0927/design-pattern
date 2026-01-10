package com.example.factory.abstractfactory;

/**
 * StarbucksFactory.
 */
public class StarbucksFactory implements CafeFactory {
    @Override
    public Coffee createCoffee() {
        return new Latte();
    }

    @Override
    public Cup createCup() {
        return new PaperCup();
    }

    @Override
    public Sugar createSugar() {
        return new WhiteSugar();
    }
}
