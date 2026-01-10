package com.example.creational.singleton;

import java.io.Serializable;

/**
 * 序列化防御示例：readResolve 保证反序列化返回同一实例。
 */
public class SerializationSafeSingleton implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final SerializationSafeSingleton INSTANCE = new SerializationSafeSingleton();

    private SerializationSafeSingleton() {
    }

    public static SerializationSafeSingleton getInstance() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
