package com.example.singleton;

/**
 * 懒汉式：线程安全方式 2
 */
public class Singleton06 {
    // 1. 私有化构造方法
    private Singleton06() {
    }

    // 2. 声明类型变量
    private static volatile Singleton06 singleton;

    // 线程安全方式 2: 双重检查锁（DCL）
    public static Singleton06 getInstance() {
        if (singleton == null) {
            synchronized (Singleton06.class) {
                if (singleton == null) {
                    singleton = new Singleton06();
                }
            }
        }
        return singleton;
    }
}
