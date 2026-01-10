package com.example.creational.factory.simple;

/**
 * CoffeeFactory.
 */
public class CoffeeFactory {

    public Coffee create(String type) {
        if ("latte".equalsIgnoreCase(type)) {
            return new Latte();
        } else if ("americano".equalsIgnoreCase(type)) {
            return new Americano();
        }
        throw new IllegalArgumentException("unknown coffee type");
    }
}
