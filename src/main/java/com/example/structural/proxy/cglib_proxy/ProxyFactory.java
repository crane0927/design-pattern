package com.example.structural.proxy.cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

/**
 * 代理工厂
 */
public class ProxyFactory {


    public Station getStation() {
        Enhancer enhancer = new Enhancer(); // 创建增强器，相当于 JDK 动态代理的 Proxy 类
        enhancer.setSuperclass(Station.class); // 设置父类
        enhancer.setCallback(new MethodInterceptor() { // 设置回调函数

            /**
             * 
             * @param obj 被代理的对象
             * @param method 被代理的方法
             * @param args 方法的参数
             * @param proxy 方法代理
             * @return 方法的返回值
             * @throws Throwable 方法的异常
             */
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("代理点收取服务费");
                return proxy.invokeSuper(obj, args);
            }
        });
        // 创建代理对象并返回
        return (Station) enhancer.create();
    }
}
