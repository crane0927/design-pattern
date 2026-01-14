package com.example.behavioral.visitor;

/**
 * 客户端（Client）
 * 
 * 演示访问者模式的使用
 * 
 * 访问者模式的工作流程：
 * 1. 创建元素对象（Dog、Cat）
 * 2. 创建访问者对象（Master、Stranger）
 * 3. 元素调用 accept(visitor) 方法接受访问
 * 4. 在 accept 方法中，元素调用 visitor.visit(this) 将自身传递给访问者
 * 5. 访问者根据元素类型和自身类型执行相应的操作
 * 
 * 双重分发机制：
 * - 第一次分发：根据元素类型（Dog/Cat）选择 accept 方法
 * - 第二次分发：根据访问者类型（Master/Stranger）选择 visit 方法
 */
public class Client {

    public static void main(String[] args) {
        // 创建元素对象
        Animal dog = new Dog();
        Animal cat = new Cat();
        
        // 创建访问者对象
        Visitor master = new Master();
        Visitor stranger = new Stranger();
        
        // 主人访问动物
        System.out.println("=== 主人访问动物 ===");
        dog.accept(master);  // 双重分发：Dog.accept() -> Master.visit(Dog)
        cat.accept(master);  // 双重分发：Cat.accept() -> Master.visit(Cat)
        
        System.out.println("=====================");
        
        // 陌生人访问动物
        System.out.println("=== 陌生人访问动物 ===");
        dog.accept(stranger);  // 双重分发：Dog.accept() -> Stranger.visit(Dog)
        cat.accept(stranger);  // 双重分发：Cat.accept() -> Stranger.visit(Cat)
    }
}
