package com.example.singleton;

/**
 * 懒汉式：线程安全方式 1
 */
public class Singleton05 {
    // 1. 私有化构造方法
    private Singleton05() {
    }

    // 2. 声明类型变量
    private static Singleton05 singleton;

    // 线程安全方式 1: 通过 synchronized 加锁实现，安全但是慢
    public static synchronized Singleton05 getInstance() {
        if (singleton == null) {
            singleton = new Singleton05();
        }
        return singleton;
    }

}
