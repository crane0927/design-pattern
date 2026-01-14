package com.example.behavioral.memento;

import java.util.Stack;

/**
 * 历史记录
 */
public class History {

    private Stack<EditorMemento> mementos = new Stack<EditorMemento>(); // 备忘录栈

    /**
     * 添加
     * @param memento
     */
    public void add(EditorMemento memento) {
        mementos.push(memento);
    }

    /**
     * 弹出（回退）
     * @return
     */
    public EditorMemento pop() {
        return mementos.pop();
    }

}
