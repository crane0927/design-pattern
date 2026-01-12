package com.example.structural.bridge;

/**
 * 普通消息
 */
public class NormalMessage extends Message {

    protected NormalMessage(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void send(String message) {
        messageSender.send("[普通]" + message);
    }

}
