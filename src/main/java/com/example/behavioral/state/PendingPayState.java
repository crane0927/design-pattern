package com.example.behavioral.state;

public class PendingPayState implements OrderState {

    @Override
    public void handle(OrderContext context) {
        System.out.println("待支付状态");
        context.transitionTo(new PaidState());
        context.handle();
    }

}
