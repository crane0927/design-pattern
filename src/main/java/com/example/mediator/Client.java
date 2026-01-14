package com.example.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户端
 */
public class Client {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        ChatMediator chatMediator = new ChatRoom(users);
        
        User user1 = new User("用户1", chatMediator);
        User user2 = new User("用户2", chatMediator);
        User user3 = new User("用户3", chatMediator);
        
        // 将用户添加到聊天室
        users.add(user1);
        users.add(user2);
        users.add(user3);
        
        user1.send("大家好，我是用户1");
        user2.send("大家好，我是用户2");
        user3.send("大家好，我是用户3");
    }
}
