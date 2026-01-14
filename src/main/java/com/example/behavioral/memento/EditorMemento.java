package com.example.behavioral.memento;

/**
 * 备忘录
 */
public class EditorMemento {

    private String content; // 内容

    public EditorMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
