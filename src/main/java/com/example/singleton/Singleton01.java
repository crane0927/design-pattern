package com.example.singleton;

/**
 * 饿汉式：静态成员变量
 */
public class Singleton01 {
    // 1. 私有化构造方法
    private Singleton01() {
    }

    // 2. 在本类中创建私有静态对象
    // 声明即初始化、JVM 自动生成 <clinit> 方法、本质上，只是 JVM 帮忙写了静态代码块
    private static Singleton01 singleton = new Singleton01();

    // 3. 提供一个公共的静态方法，返回静态对象
    public static Singleton01 getInstance() {
        return singleton;
    }

}
