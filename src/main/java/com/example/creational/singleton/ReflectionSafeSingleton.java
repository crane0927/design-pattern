package com.example.creational.singleton;

/**
 * 反射防御示例（普通类单例）。
 */
public class ReflectionSafeSingleton {
    private static final ReflectionSafeSingleton INSTANCE = new ReflectionSafeSingleton();
    private static boolean initialized = false;

    private ReflectionSafeSingleton() {
        if (initialized) {
            throw new RuntimeException("No reflection allowed");
        }
        initialized = true;
    }

    public static ReflectionSafeSingleton getInstance() {
        return INSTANCE;
    }
}
