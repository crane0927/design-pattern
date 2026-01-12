package com.example.structural.flyweight;

/**
 * 俄罗斯方块游戏中的方块抽象类
 * 抽象享元类
 */
public abstract class AbstractBox {

    protected String color;

    public void setColor(String color) {
        this.color = color;
    }



    public abstract String getShape();

    @Override
    public String toString() {
        return "AbstractBox{" +
                "color='" + color + '\'' +
                ", shape='" + getShape() + '\'' +
                '}';
    }
}
