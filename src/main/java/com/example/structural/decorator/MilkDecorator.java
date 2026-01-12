package com.example.structural.decorator;

public class MilkDecorator extends CoffeeDecorator {

    protected MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.cost() + 2.0;
    }

    @Override
    public String description() {
        return super.description() + " + 牛奶";
    }
}
