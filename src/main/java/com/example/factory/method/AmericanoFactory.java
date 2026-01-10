package com.example.factory.method;

/**
 * AmericanoFactory.
 */
public class AmericanoFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        return new Americano();
    }
}
