package com.example.creational.factory.abstract_factory;

/**
 * 纸杯子.
 */
public class PaperCup implements Cup {
    @Override
    public String material() {
        return "纸杯子";
    }
}
