package com.example.creational.singleton;

import java.lang.reflect.Constructor;

/**
 * 反射破坏单例示例。
 */
public class ReflectionBreakDemo {

    public static void main(String[] args) throws Exception {
        EagerStaticSingleton s1 = EagerStaticSingleton.getInstance();

        Constructor<EagerStaticSingleton> constructor = EagerStaticSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        EagerStaticSingleton s2 = constructor.newInstance();

        System.out.println(s1 == s2);
    }
}
