package com.example.behavioral.visitor;

/**
 * 陌生人（ConcreteVisitor）
 * 
 * 访问者模式中的具体访问者类，实现 Visitor 接口
 * 定义了陌生人对不同动物的操作逻辑
 * 
 * 访问者模式的优势：
 * - 可以轻松添加新的访问者，无需修改元素类（Dog、Cat）
 * - 每个访问者可以定义不同的操作逻辑
 * - 操作逻辑集中在访问者中，便于维护和扩展
 */
public class Stranger implements Visitor {

    /**
     * 陌生人访问猫
     * 
     * 定义了陌生人对猫的操作逻辑
     * 与 Master 的 visit(Cat) 方法不同，体现了不同访问者的不同行为
     * 
     * @param cat 被访问的猫对象
     */
    @Override
    public void visit(Cat cat) {
        System.out.println("陌生人喂猫");
        System.out.println("猫吃鱼");
    }

    /**
     * 陌生人访问狗
     * 
     * 定义了陌生人对狗的操作逻辑
     * 与 Master 的 visit(Dog) 方法不同，体现了不同访问者的不同行为
     * 
     * @param dog 被访问的狗对象
     */
    @Override
    public void visit(Dog dog) {
        System.out.println("陌生人喂狗");
        System.out.println("狗吃骨头");
    }
}
