package com.example.singleton;

/**
 * 客户端
 */
public class Client {

    public static void main(String[] args) {
        // 饿汉式：静态方法
        EagerStaticSingleton instance1 = EagerStaticSingleton.getInstance();
        EagerStaticSingleton instance2 = EagerStaticSingleton.getInstance();

        // 判断是否获取的对象是同一个
        System.out.println(instance1 == instance2);

        // 饿汉式：静态代码块
        EagerStaticBlockSingleton instance3 = EagerStaticBlockSingleton.getInstance();
        EagerStaticBlockSingleton instance4 = EagerStaticBlockSingleton.getInstance();

        System.out.println(instance3 == instance4);

        // 饿汉式：枚举
        EnumSingleton instance5 = EnumSingleton.INSTANCE;
        EnumSingleton instance6 = EnumSingleton.INSTANCE;

        System.out.println(instance5 == instance6);

        // 懒汉式：线程不安全
        LazyUnsafeSingleton instance7 = LazyUnsafeSingleton.getInstance();
        LazyUnsafeSingleton instance8 = LazyUnsafeSingleton.getInstance();

        System.out.println(instance7 == instance8);

        // 懒汉式：线程安全方式 1
        LazySynchronizedSingleton instance9 = LazySynchronizedSingleton.getInstance();
        LazySynchronizedSingleton instance10 = LazySynchronizedSingleton.getInstance();

        System.out.println(instance9 == instance10);

        // 懒汉式：线程安全方式 2
        LazyDclSingleton instance11 = LazyDclSingleton.getInstance();
        LazyDclSingleton instance12 = LazyDclSingleton.getInstance();

        System.out.println(instance11 == instance12);

        // 懒汉式：静态内部类
        StaticInnerClassSingleton instance13 = StaticInnerClassSingleton.getInstance();
        StaticInnerClassSingleton instance14 = StaticInnerClassSingleton.getInstance();

        System.out.println(instance13 == instance14);
    }

}
