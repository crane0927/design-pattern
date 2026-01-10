package com.example.creational.factory.direct;

/**
 * 直接实例化 demo
 */
public class DirectDemo {

    public static void main(String[] args) {
        // 1. 直接实例化
        OrderService orderService = new OrderService();
        Coffee latte = orderService.order("latte");
        Coffee americano = orderService.order("americano");
        System.out.println(latte.name());
        System.out.println(americano.name());
    }
}
