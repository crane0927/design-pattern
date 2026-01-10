package com.example.factory.direct;

/**
 * Americano.
 */
public class Americano implements Coffee {
    @Override
    public String name() {
        return "Americano"; // 美式
    }
}
