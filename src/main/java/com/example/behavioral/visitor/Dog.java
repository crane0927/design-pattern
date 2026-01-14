package com.example.behavioral.visitor;

/**
 * 狗类（ConcreteElement）
 * 
 * 访问者模式中的具体元素类，实现 Animal 接口
 * accept 方法只负责调用访问者的 visit 方法，不包含任何业务逻辑
 * 所有操作逻辑都应该在访问者的 visit 方法中实现
 */
public class Dog implements Animal {

    /**
     * 接受访问者访问
     * 
     * 实现双重分发机制：
     * 1. 第一次分发：根据元素类型（Dog）选择此 accept 方法
     * 2. 第二次分发：调用 visitor.visit(this)，根据访问者类型（Master/Stranger）选择对应的 visit(Dog) 方法
     * 
     * 注意：accept 方法中不应该包含业务逻辑，所有操作都应该在访问者的 visit 方法中实现
     * 
     * @param visitor 访问者对象
     */
    @Override
    public void accept(Visitor visitor) {
        // 调用访问者的 visit 方法，将自身（this）传递给访问者
        // 访问者会根据自身类型（Master/Stranger）执行相应的操作
        visitor.visit(this);
    }
}
