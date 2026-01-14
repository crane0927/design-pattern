package com.example.behavioral.memento;

public class Client {
    public static void main(String[] args) {
        History history = new History();
        TextEditor textEditor = new TextEditor();
        textEditor.setContent("1");
        history.add(textEditor.save());
        textEditor.setContent("2");
        history.add(textEditor.save());
        textEditor.setContent("3");
        // history.add(textEditor.save()); 不需要保存到历史记录中
        System.out.println(textEditor.getContent());
        textEditor.restore(history.pop());
        System.out.println("=====================");
        System.out.println(textEditor.getContent());
    }

}
