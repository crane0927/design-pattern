package com.example.factory.abstractfactory;

/**
 * CafeFactory.
 */
public interface CafeFactory {
    Coffee createCoffee();
    Cup createCup();
    Sugar createSugar();
}
