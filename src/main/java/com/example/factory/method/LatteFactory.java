package com.example.factory.method;

/**
 * LatteFactory.
 */
public class LatteFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        return new Latte();
    }
}
