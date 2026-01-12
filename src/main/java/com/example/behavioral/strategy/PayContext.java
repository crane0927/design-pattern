package com.example.behavioral.strategy;

/**
 * 支付上下文
 */
public class PayContext {

    private PayStrategy payStrategy;

    public PayContext(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    public void pay(double amount) {
        payStrategy.pay(amount);
    }

}
