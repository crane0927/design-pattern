package com.example.structural.bridge;

public class SmsMessageSender implements MessageSender {
    @Override
    public void send(String message) {
        System.out.println("短信发送: " + message);
    }

}
