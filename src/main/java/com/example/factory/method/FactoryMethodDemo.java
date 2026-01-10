package com.example.factory.method;

/**
 * 工厂方法 demo
 */
public class FactoryMethodDemo {

    public static void main(String[] args) {
        OrderService latteOrder = new OrderService(new LatteFactory());
        OrderService americanoOrder = new OrderService(new AmericanoFactory());
        System.out.println(latteOrder.order().name());
        System.out.println(americanoOrder.order().name());
    }
}
