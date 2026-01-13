package com.example.behavioral.state;

/**
 * 订单上下文
 */
public class OrderContext {

    private OrderState currentState; // 当前状态

    public OrderContext(OrderState currentState) { // 初始化当前状态
        this.currentState = currentState;
    }

    public void setCurrentState(OrderState currentState) { // 设置当前状态
        this.currentState = currentState;
    }

    public void handle() { // 处理订单
        currentState.handle(this);
    }
}
