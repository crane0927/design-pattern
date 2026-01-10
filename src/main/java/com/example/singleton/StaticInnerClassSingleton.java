package com.example.singleton;

/**
 * 懒汉式：静态内部类
 */
public class StaticInnerClassSingleton {
    // 1. 私有化构造方法
    private StaticInnerClassSingleton() {
    }

    // 2. 静态内部类
    private static class Holder {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    // 3. 提供一个公共的静态方法，返回静态对象
    public static StaticInnerClassSingleton getInstance() {
        return Holder.INSTANCE;
    }
}
