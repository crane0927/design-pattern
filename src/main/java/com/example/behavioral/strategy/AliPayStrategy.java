package com.example.behavioral.strategy;

public class AliPayStrategy implements PayStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("支付宝支付：" + amount);
    }

}
