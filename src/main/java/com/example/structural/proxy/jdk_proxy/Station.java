package com.example.structural.proxy.jdk_proxy;

/**
 * 火车站
 */
public class Station implements SellTickets {

    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }

}
