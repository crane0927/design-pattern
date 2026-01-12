package com.example.structural.flyweight;

/**
 * 俄罗斯方块游戏中的方块抽象类
 * 抽象享元类
 */
public abstract class AbstractBox {

    /**
     * 获取形状（内部状态，可共享）
     * @return 形状
     */
    public abstract String getShape();

    /**
     * 显示方块信息（颜色作为外部状态传入）
     * @param color 颜色（外部状态，不可共享）
     * @return 方块信息字符串
     */
    public String display(String color) {
        return "AbstractBox{" +
                "color='" + color + '\'' +
                ", shape='" + getShape() + '\'' +
                '}';
    }

    /**
     * toString 方法（不包含外部状态）
     */
    @Override
    public String toString() {
        return "AbstractBox{shape='" + getShape() + "'}";
    }
}
