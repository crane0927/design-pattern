package com.example.structural.bridge;

public class EmailMessageSender implements MessageSender {
    @Override
    public void send(String message) {
        System.out.println("邮件发送: " + message);
    }

}
