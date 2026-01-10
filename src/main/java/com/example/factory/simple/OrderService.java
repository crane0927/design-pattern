package com.example.factory.simple;

/**
 * OrderService.
 */
public class OrderService {

    private final CoffeeFactory factory = new CoffeeFactory();

    public Coffee order(String type) {
        return factory.create(type);
    }
}
