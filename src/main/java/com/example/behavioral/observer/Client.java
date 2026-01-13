package com.example.behavioral.observer;

/**
 * 客户端
 */
public class Client {

    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();
        Observer observer1 = new WcChatUser("张三");
        Observer observer2 = new WcChatUser("李四");
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.notifyObservers("公众号更新了1"); // 通知观察者
        subject.removeObserver(observer1); // 删除观察者
        subject.notifyObservers("公众号更新了2"); // 通知观察者
    }

}
