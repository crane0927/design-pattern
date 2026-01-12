package com.example.structural.decorator;

public class Client {

    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.cost());
        System.out.println(coffee.description());
        System.out.println("=====================");
        coffee = new MilkDecorator(coffee);  // 加牛奶
        System.out.println(coffee.cost());
        System.out.println(coffee.description());
        System.out.println("=====================");
        coffee = new SugarDecorator(coffee); // 加糖
        System.out.println(coffee.cost());
        System.out.println(coffee.description());
    }

}
