package com.example.factory.simple;

/**
 * 简单工厂 demo
 */
public class SimpleFactoryDemo {

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        Coffee latte = orderService.order("latte");
        Coffee americano = orderService.order("americano");
        System.out.println(latte.name());
        System.out.println(americano.name());
    }
}
