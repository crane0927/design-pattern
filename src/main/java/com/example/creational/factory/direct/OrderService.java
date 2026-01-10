package com.example.creational.factory.direct;

/**
 * OrderService.
 */
public class OrderService {

    public Coffee order(String type) {
        if ("latte".equalsIgnoreCase(type)) {
            return new Latte();
        } else if ("americano".equalsIgnoreCase(type)) {
            return new Americano();
        }
        throw new IllegalArgumentException("unknown coffee type");
    }
}
