package com.example.factory.staticfactory;

/**
 * CoffeeStaticFactory.
 */
public class CoffeeStaticFactory {

    private CoffeeStaticFactory() {
    }

    public static Coffee create(String type) {
        if ("latte".equalsIgnoreCase(type)) {
            return new Latte();
        } else if ("americano".equalsIgnoreCase(type)) {
            return new Americano();
        }
        throw new IllegalArgumentException("unknown coffee type");
    }
}
