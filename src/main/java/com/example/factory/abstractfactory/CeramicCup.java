package com.example.factory.abstractfactory;

/**
 * 瓷杯子.
 */
public class CeramicCup implements Cup {
    @Override
    public String material() {
        return "瓷杯子";
    }
}
