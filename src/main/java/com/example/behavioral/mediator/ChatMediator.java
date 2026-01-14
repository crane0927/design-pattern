package com.example.behavioral.mediator;

/**
 * 聊天室中介者接口
 */
public interface ChatMediator {

    void sendMessage(String message, User user);
}

