package com.example.structural.proxy.staticproxy;

public class Client {

    public static void main(String[] args) {
        ProxyPoint proxyPoint = new ProxyPoint(new Station());
        proxyPoint.sell();
    }

}
