package com.example.behavioral.observer;

/**
 * 观察者接口
 * 定义了观察者接口，每个观察者都需要实现这个接口
 */
public interface Observer {

    /**
     * 更新
     * @param message 消息
     */
    void update(String message);

}
