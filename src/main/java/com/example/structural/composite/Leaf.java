package com.example.structural.composite;

/**
 * 叶子节点
 */
public class Leaf extends Component {

    protected Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("叶子节点不能添加子节点");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("叶子节点不能删除子节点");
    }

    @Override
    public void display(String prefix, boolean isLast) {
        // 打印叶子节点
        System.out.println(prefix + (isLast ? "└─ " : "├─ ") + name + " (Leaf)");
    }
}
