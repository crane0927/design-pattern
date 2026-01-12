package com.example.structural.flyweight;

public class Client {

    public static void main(String[] args) {
        // 获取 I 型方块（共享同一个对象）
        AbstractBox box1 = BoxFactory.getBox("I");
        AbstractBox box2 = BoxFactory.getBox("I");
        
        // 颜色作为外部状态传入，不影响共享对象
        System.out.println(box1.display("红色"));  // AbstractBox{color='红色', shape='I'}
        System.out.println(box2.display("绿色"));  // AbstractBox{color='绿色', shape='I'}
        System.out.println(box1 == box2);  // true（同一个对象）
        
        System.out.println("=====================");
        
        // 获取 J 型方块
        AbstractBox box3 = BoxFactory.getBox("J");
        System.out.println(box3.display("蓝色"));
        System.out.println(box1 == box3);  // false（不同对象）
        
        System.out.println("=====================");
        
        // 获取 L 型方块
        AbstractBox box4 = BoxFactory.getBox("L");
        System.out.println(box4.display("黄色"));
        
        System.out.println("=====================");
        
        // 同一个对象可以有不同的外部状态
        System.out.println("box1 红色: " + box1.display("红色"));
        System.out.println("box1 蓝色: " + box1.display("蓝色"));
        System.out.println("box1 == box2: " + (box1 == box2));  // 仍然是同一个对象
    }
}
