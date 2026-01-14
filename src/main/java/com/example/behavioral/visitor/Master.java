package com.example.behavioral.visitor;

/**
 * 主人（ConcreteVisitor）
 * 
 * 访问者模式中的具体访问者类，实现 Visitor 接口
 * 定义了主人对不同动物的操作逻辑
 * 
 * 访问者模式的优势：
 * - 将操作逻辑从元素类中分离出来，封装在访问者中
 * - 可以轻松添加新的访问者（如 Stranger），无需修改元素类
 * - 每个访问者可以定义不同的操作逻辑
 */
public class Master implements Visitor {

    /**
     * 主人访问狗
     * 
     * 定义了主人对狗的操作逻辑
     * 所有与"主人和狗"相关的操作都应该在这里实现
     * 
     * @param dog 被访问的狗对象
     */
    @Override
    public void visit(Dog dog) {
        System.out.println("主人喂狗");
        System.out.println("狗吃骨头");
    }

    /**
     * 主人访问猫
     * 
     * 定义了主人对猫的操作逻辑
     * 所有与"主人和猫"相关的操作都应该在这里实现
     * 
     * @param cat 被访问的猫对象
     */
    @Override
    public void visit(Cat cat) {
        System.out.println("主人喂猫");
        System.out.println("猫吃鱼");
    }
}
