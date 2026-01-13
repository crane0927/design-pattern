package com.example.behavioral.state2;

/**
 * 订单状态接口
 * 
 * 定义了订单状态的接口，每个状态都需要实现这个接口
 */
public interface OrderState {

    void handle(OrderContext context);

}
