package com.example.structural.flyweight;

public class Client {

    public static void main(String[] args) {
        AbstractBox box1 = BoxFactory.getBox("I");
        box1.setColor("红色");
        AbstractBox box2 = BoxFactory.getBox("I");
        box2.setColor("绿色");
        System.out.println(box1);
        System.out.println(box2);
        System.out.println(box1 == box2);
        System.out.println("=====================");
        AbstractBox box3 = BoxFactory.getBox("J");
        box3.setColor("蓝色");
        System.out.println(box3);
        System.out.println(box1 == box3);
        System.out.println("=====================");
        AbstractBox box4 = BoxFactory.getBox("L");
        box4.setColor("黄色");
        System.out.println(box4);
    }
}
