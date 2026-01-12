package com.example.structural.decorator;

public class SugarDecorator extends CoffeeDecorator {

    protected SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.cost() + 1.0;
    }

    @Override
    public String description() {
        return super.description() + " + 糖";
    }
}
