package com.example.creational.singleton;

/**
 * 懒汉式：第一次调用时才创建
 * 懒汉式 vs 饿汉式
 * 1. 饿汉式：类加载时就创建对象，线程安全，但可能浪费资源
 * 2. 懒汉式：第一次使用才创建对象，节省资源，但默认实现线程不安全
 */
public class LazyUnsafeSingleton {
    // 1. 私有化构造方法
    private LazyUnsafeSingleton() {
    }

    // 2. 声明类型变量
    private static LazyUnsafeSingleton singleton;

    // 3.第一次调用时创建，线程不安全
    public static LazyUnsafeSingleton getInstance() {
        if (singleton == null) {
            singleton = new LazyUnsafeSingleton();
        }
        return singleton;
    }


    

}
