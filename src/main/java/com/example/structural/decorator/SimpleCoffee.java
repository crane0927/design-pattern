package com.example.structural.decorator;

public class SimpleCoffee implements Coffee {

    @Override
    public double cost() {
        return 10.0;
    }

    @Override
    public String description() {
        return "原味咖啡";
    }

}
