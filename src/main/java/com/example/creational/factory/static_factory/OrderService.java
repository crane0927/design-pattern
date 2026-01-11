package com.example.creational.factory.static_factory;

/**
 * OrderService.
 */
public class OrderService {

    public Coffee order(String type) {
        return CoffeeStaticFactory.create(type);
    }
}
