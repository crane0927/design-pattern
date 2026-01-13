package com.example.behavioral.state2;

/**
 * 已发货状态
 */
public class ShippedState implements OrderState {

    @Override
    public void handle(OrderContext context) {
        System.out.println("已发货状态");
    }
}
