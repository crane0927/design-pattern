package com.example.structural.proxy.jdk_proxy;

public class Client {

    public static void main(String[] args) {
        /*
        动态代理执行流程
        1. 通过代理对象调用 sell() 方法
        2. 由于 sellTickets 指向的是动态生成的代理对象，所以会执行代理类中的 sell() 方法
        3. 代理类中的 sell() 方法会调用传入的 InvocationHandler 实现类（匿名内部类）的 invoke() 方法
        4. invoke() 方法通过反射执行真实对象 Station 中的 sell() 方法
        */
        ProxyFactory proxyFactory = new ProxyFactory(new Station());
        SellTickets sellTickets = proxyFactory.getSellTickets();
        sellTickets.sell(); // 执行被代理对象的 sell 方法

    }

}
