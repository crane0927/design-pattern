package com.example.factory.abstractfactory;

/**
 * 纸杯子.
 */
public class PaperCup implements Cup {
    @Override
    public String material() {
        return "纸杯子";
    }
}
