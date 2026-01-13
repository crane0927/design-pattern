package com.example.behavioral.observer;

/**
 * 主题（被观察者抽象接口）
 */
public interface Subject {

    /**
     * 添加观察者
     * @param observer 观察者
     */
    void addObserver(Observer observer);

    /**
     * 删除观察者
     * @param observer 观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     * @param message 消息
     */
    void notifyObservers(String message);

}
