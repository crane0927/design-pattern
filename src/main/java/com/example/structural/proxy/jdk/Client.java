package com.example.structural.proxy.jdk;

public class Client {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new Station());
        SellTickets sellTickets = proxyFactory.getSellTickets();
        sellTickets.sell(); // 执行被代理对象的 sell 方法

    }

}
