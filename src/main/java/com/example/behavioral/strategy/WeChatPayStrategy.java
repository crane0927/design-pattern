package com.example.behavioral.strategy;

public class WeChatPayStrategy implements PayStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("微信支付：" + amount);
    }

}
