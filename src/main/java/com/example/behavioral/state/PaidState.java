package com.example.behavioral.state;

public class PaidState implements OrderState {

    @Override
    public void handle(OrderContext context) {
        System.out.println("已支付状态");
        context.transitionTo(new ShippedState());
        context.handle();

    }

}
