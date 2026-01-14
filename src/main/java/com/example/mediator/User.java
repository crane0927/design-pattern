package com.example.mediator;

/**
 * 用户类
 */
public class User {

    protected String name;
    protected ChatMediator chatMediator; // 聊天室中介者

    public User(String name, ChatMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
    }

    public void send(String message) { // 发送消息
        chatMediator.sendMessage(message, this);
    }

    public void receive(String message) { // 收到消息
        System.out.println(name + "收到消息: " + message);
    }
}
