package com.example.structural.proxy.static_proxy;

public class Client {

    public static void main(String[] args) {
        ProxyPoint proxyPoint = new ProxyPoint(new Station());
        proxyPoint.sell();
    }

}
