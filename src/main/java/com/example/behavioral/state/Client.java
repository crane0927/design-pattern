package com.example.behavioral.state;

public class Client {

    public static void main(String[] args) {
        OrderContext orderContext = new OrderContext(new PendingPayState());
        orderContext.handle();
    }

}
