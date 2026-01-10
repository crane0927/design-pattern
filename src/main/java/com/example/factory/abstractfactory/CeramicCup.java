package com.example.factory.abstractfactory;

/**
 * CeramicCup.
 */
public class CeramicCup implements Cup {
    @Override
    public String material() {
        return "Ceramic";
    }
}
