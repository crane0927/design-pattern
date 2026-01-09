package com.example.singleton;

/**
 * 客户端
 */
public class Client {

    public static void main(String[] args) {
        // 饿汉式：静态方法
        Singleton01 instance1 = Singleton01.getInstance();
        Singleton01 instance2 = Singleton01.getInstance();

        // 判断是否获取的对象是同一个
        System.out.println(instance1 == instance2);

        // 饿汉式：静态代码块
        Singleton02 instance3 = Singleton02.getInstance();
        Singleton02 instance4 = Singleton02.getInstance();

        System.out.println(instance3 == instance4);

        // 饿汉式：枚举
        Singleton03 instance5 = Singleton03.INSTANCE;
        Singleton03 instance6 = Singleton03.INSTANCE;

        System.out.println(instance5 == instance6);

        // 懒汉式：线程不安全
        Singleton04 instance7 = Singleton04.getInstance();
        Singleton04 instance8 = Singleton04.getInstance();

        System.out.println(instance7 == instance8);

        // 懒汉式：线程安全方式 1
        Singleton05 instance9 = Singleton05.getInstance();
        Singleton05 instance10 = Singleton05.getInstance();

        System.out.println(instance9 == instance10);

        // 懒汉式：线程安全方式 2
        Singleton06 instance11 = Singleton06.getInstance();
        Singleton06 instance12 = Singleton06.getInstance();

        System.out.println(instance11 == instance12);

        // 懒汉式：静态内部类
        Singleton07 instance13 = Singleton07.getInstance();
        Singleton07 instance14 = Singleton07.getInstance();

        System.out.println(instance13 == instance14);
    }

}
