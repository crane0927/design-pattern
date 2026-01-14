package com.example.behavioral.mediator;

import java.util.List;

/**
 * 聊天室中介者，具体实现
 */
public class ChatRoom implements ChatMediator {

    private List<User> users;

    public ChatRoom(List<User> users) {
        this.users = users;
    }

    @Override
    public void sendMessage(String message, User user) {
        // 打印发送者信息（只打印一次）
        System.out.println(user.name + "发送消息: " + message);
        // 通知其他用户
        for (User u : users) {
            if (u != user) { // 排除发送者自己
                u.receive(message);
            }
        }
    }
}
