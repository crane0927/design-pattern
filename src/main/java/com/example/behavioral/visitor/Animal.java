package com.example.behavioral.visitor;

/**
 * 动物接口（Element）
 * 
 * 访问者模式中的元素接口，定义接受访问者的方法
 * 所有具体元素类都需要实现这个接口
 */
public interface Animal {

    /**
     * 接受访问者访问
     * 
     * 这是访问者模式的核心方法，实现双重分发：
     * 1. 第一次分发：根据元素类型（Dog/Cat）选择 accept 方法
     * 2. 第二次分发：在 accept 方法中调用 visitor.visit(this)，根据访问者类型选择 visit 方法
     * 
     * @param visitor 访问者对象
     */
    void accept(Visitor visitor);
}
