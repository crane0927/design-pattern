package com.example.creational.factory.method;

/**
 * AmericanoFactory.
 */
public class AmericanoFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        return new Americano();
    }
}
