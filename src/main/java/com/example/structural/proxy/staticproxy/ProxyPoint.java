package com.example.structural.proxy.staticproxy;

/**
 * 代理点
 */
public class ProxyPoint  implements SellTickets{

    private Station station;

    public ProxyPoint(Station station) {
        this.station = station;
    }

    @Override
    public void sell() {
        System.out.println("代理点收取服务费");
        station.sell();
    }
}
