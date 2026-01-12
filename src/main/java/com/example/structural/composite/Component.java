package com.example.structural.composite;

/**
 * 抽象构建
 */
public abstract class Component {

    protected String name;

    protected Component(String name) {
        this.name = name;
    }

    // 透明模式：定义一系列方法，子类必须实现这些方法，但是对于某些子类来说，这些方法是不适用的，比如叶子节点
    // 安全模式：不定义方法，子类可以选择实自己要实现哪些方法，但是每个子类的方法可能不同
    public abstract void add(Component composite);

    public abstract void remove(Component composite);

    /**
     * 显示节点名称，并递归显示子节点
     * @param prefix 前缀字符串（用于树形结构显示）
     * @param isLast 是否为最后一个子节点
     */
    public abstract void display(String prefix, boolean isLast);
    
    /**
     * 显示节点（默认方法，从根节点开始）
     */
    public void display() {
        display("", true);
    }

}
