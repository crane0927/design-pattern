package com.example.singleton;

/**
 * 懒汉式：线程安全方式 2
 */
public class LazyDclSingleton {
    // 1. 私有化构造方法
    private LazyDclSingleton() {
    }

    // 2. 声明类型变量
    private static volatile LazyDclSingleton singleton;

    // 线程安全方式 2: 双重检查锁（DCL）
    public static LazyDclSingleton getInstance() {
        if (singleton == null) {
            synchronized (LazyDclSingleton.class) {
                if (singleton == null) {
                    singleton = new LazyDclSingleton();
                }
            }
        }
        return singleton;
    }
}
