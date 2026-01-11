package com.example.structural.proxy.jdk_proxy;

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

    /*
    动态代理类是在内存中的，ProxyFactory 不是代理类，只是一个代理工厂
    动态代理类会继承 Proxy 类，被代理对象 Station 实现了 SellTickets，动态代理类也实现了 SellTickets
    动态代理类都有参构造接收匿名内部类 InvocationHandler ，并赋值给 Proxy 中的属性 protected InvocationHandler h 
    动态代理类调用 sell() 方法，sell() 方法中又调用了 InvocationHandler 的 invoke 方法
    invoke 方法 通过反射执行类真实对象所属类【Station】中的 sell() 方法
    */

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
             *  method 被调用的方法对象
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
