package com.example.structural.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂
 */
public class ProxyFactory {

    private Station station; // 声明目标对象， 火车站

    public ProxyFactory(Station station) {
        this.station = station;
    }

    public SellTickets getSellTickets(){
        // 返回代理对象

        /*
        ClassLoader loader, 类加载器，用于加载代理类，可以通过目标对象获取
        Class<?>[] interfaces, 代理类实现的接口字节码对象
        InvocationHandler h  代理对象的调用处理程序
        */
        SellTickets newProxyInstance = (SellTickets)Proxy.newProxyInstance(
            station.getClass().getClassLoader(), 
        station.getClass().getInterfaces(), 
        new InvocationHandler(){
            /**
             *  proxy 被代理的对象，等同于 newProxyInstance
             *  method 被代理的对象的方法中的方法
             *  args 方法的执行参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("代理点收取服务费");
                Object result = method.invoke(station, args);
                return result; // 方法的返回值
            }
        });
        return newProxyInstance;
    }
}
