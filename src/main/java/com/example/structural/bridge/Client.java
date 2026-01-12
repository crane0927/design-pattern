package com.example.structural.bridge;

public class Client {

    public static void main(String[] args) {
        MessageSender messageSender = new EmailMessageSender();
        Message message = new NormalMessage(messageSender); // 普通消息
        message.send("普通消息");
        message = new UrgentMessage(messageSender); // 紧急消息
        message.send("紧急消息");

        SmsMessageSender smsMessageSender = new SmsMessageSender();
        message = new NormalMessage(smsMessageSender); // 普通消息
        message.send("普通消息");
        message = new UrgentMessage(smsMessageSender); // 紧急消息
        message.send("紧急消息");
    }

}
