package com.example.singleton;

/**
 * 懒汉式：静态内部类
 */
public class Singleton07 {
    // 1. 私有化构造方法
    private Singleton07() {
    }

    // 2. 静态内部类
    private static class Holder {
        private static final Singleton07 INSTANCE = new Singleton07();
    }

    // 3. 提供一个公共的静态方法，返回静态对象
    public static Singleton07 getInstance() {
        return Holder.INSTANCE;
    }
}
