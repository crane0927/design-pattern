package com.example.behavioral.state;

/**
 * 订单上下文
 */
public class OrderContext {

    private OrderState currentState; // 当前状态

    public OrderContext(OrderState currentState) { // 初始化当前状态
        this.currentState = currentState;
    }

    /**
     * 转换到下一个状态
     * @param nextState 下一个状态
     */
    public void transitionTo(OrderState nextState) {
        this.currentState = nextState;
    }

    /**
     * 处理订单
     * 委托给当前状态处理
     */
    public void handle() {
        currentState.handle(this);
    }
}
