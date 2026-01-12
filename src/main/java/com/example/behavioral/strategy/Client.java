package com.example.behavioral.strategy;

public class Client {

    public static void main(String[] args) {
        PayContext payContext = new PayContext(new AliPayStrategy());
        payContext.pay(100);
        System.out.println("=====================");
        payContext = new PayContext(new WeChatPayStrategy());
        payContext.pay(100);
    }

}
