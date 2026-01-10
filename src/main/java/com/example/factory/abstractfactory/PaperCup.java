package com.example.factory.abstractfactory;

/**
 * PaperCup.
 */
public class PaperCup implements Cup {
    @Override
    public String material() {
        return "Paper";
    }
}
