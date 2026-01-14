package com.example.behavioral.memento;

/**
 * 文本编辑器
 */
public class TextEditor {

    private String content;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 保存
     * @return
     */
    public EditorMemento save() {
        return new EditorMemento(content); // 创建备忘录
    }

    /**
     * 恢复
     * @param memento
     */
    public void restore(EditorMemento memento) {
        this.content = memento.getContent();
    }

}
