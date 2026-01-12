package com.example.structural.bridge;

/**
 * 紧急消息
 */
public class UrgentMessage extends Message {

    protected UrgentMessage(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void send(String message) {
        messageSender.send("[紧急] " + message);
    }

}
