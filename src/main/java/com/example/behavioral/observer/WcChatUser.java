package com.example.behavioral.observer;

/**
 * 微信公众号用户，具体的观察者
 */
public class WcChatUser implements Observer {

    private String name;

    public WcChatUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "收到消息: " + message);
    }

}
