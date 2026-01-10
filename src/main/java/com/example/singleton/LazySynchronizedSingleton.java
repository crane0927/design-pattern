package com.example.singleton;

/**
 * 懒汉式：线程安全方式 1
 */
public class LazySynchronizedSingleton {
    // 1. 私有化构造方法
    private LazySynchronizedSingleton() {
    }

    // 2. 声明类型变量
    private static LazySynchronizedSingleton singleton;

    // 线程安全方式 1: 通过 synchronized 加锁实现，安全但是慢
    public static synchronized LazySynchronizedSingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySynchronizedSingleton();
        }
        return singleton;
    }

}
