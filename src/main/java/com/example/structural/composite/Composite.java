package com.example.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 容器节点
 */
public class Composite extends Component {
    private List<Component> children = new ArrayList<>();

    protected Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void display(String prefix, boolean isLast) {
        // 打印当前节点
        System.out.println(prefix + (isLast ? "└─ " : "├─ ") + name + " (Composite)");
        
        // 递归打印子节点
        String childPrefix = prefix + (isLast ? "   " : "│  ");
        for (int i = 0; i < children.size(); i++) {
            boolean isLastChild = (i == children.size() - 1);
            children.get(i).display(childPrefix, isLastChild);
        }
    }

}

