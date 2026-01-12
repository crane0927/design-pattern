package com.example.structural.bridge;

/**
 * 消息
 */
public abstract class Message {

    protected MessageSender messageSender; // 消息发送者

    protected Message(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public abstract void send(String message);  // 抽象方法

}
