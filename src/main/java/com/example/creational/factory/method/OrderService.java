package com.example.creational.factory.method;

/**
 * OrderService.
 */
public class OrderService {

    private final CoffeeFactory factory;

    public OrderService(CoffeeFactory factory) {
        this.factory = factory;
    }

    public Coffee order() {
        return factory.createCoffee();
    }
}
