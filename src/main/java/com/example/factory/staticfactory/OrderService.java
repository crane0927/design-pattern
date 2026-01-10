package com.example.factory.staticfactory;

/**
 * OrderService.
 */
public class OrderService {

    public Coffee order(String type) {
        return CoffeeStaticFactory.create(type);
    }
}
