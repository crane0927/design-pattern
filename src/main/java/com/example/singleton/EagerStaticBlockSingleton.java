package com.example.singleton;

/**
 * 饿汉式：静态代码块
 * 静态方法 vs 静态代码块
 * 相同点：
 * 1. 都在类加载阶段完成初始化
 * 2. 都依赖 JVM 的类初始化锁（<clinit>）
 * 3. 天然线程安全
 * 4. 都是饿汉式
 * 5. 静态方法方法本质是 JVM 帮忙写了静态代码块
 * 不同点：
 * 静态方法：
 * 1. 代码极简、直观
 * 2. JVM 自动生成 <clinit> 方法
 * 3. 代码极简、直观
 * 静态代码块：
 * 1. 可以写 复杂初始化逻辑
 */
public class EagerStaticBlockSingleton {
    // 1. 私有化构造方法
    private EagerStaticBlockSingleton() {
    }

    // 2. 声明类型变量
    private static EagerStaticBlockSingleton singleton;

    // 3. 在本类中创建静态代码块
    static {
        // 可以写 复杂初始化逻辑
        singleton = new EagerStaticBlockSingleton();
    }

    // 4. 提供一个公共的静态方法，返回静态对象
    public static EagerStaticBlockSingleton getInstance() {
        return singleton;
    }

}
