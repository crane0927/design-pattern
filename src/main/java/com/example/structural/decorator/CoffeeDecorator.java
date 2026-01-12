package com.example.structural.decorator;

/**
 * 咖啡装饰器
 */
public abstract class CoffeeDecorator implements Coffee {

    protected Coffee coffee;

    protected  CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    public double cost() {
        return coffee.cost();
    }

    @Override
    public String description() {
        return coffee.description();
    }
}
