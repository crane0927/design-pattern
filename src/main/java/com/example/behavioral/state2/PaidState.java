package com.example.behavioral.state2;

/**
 * 已支付状态（改进版）
 * 使用状态转换管理器，符合开闭原则
 */
public class PaidState implements OrderState {

    @Override
    public void handle(OrderContext context) {
        // ① 执行当前状态的处理逻辑
        System.out.println("已支付状态");
        
        // ② 使用状态转换管理器获取下一个状态
        OrderState nextState = StateTransitionManager.getNextState(this.getClass());
        if (nextState != null) {
            context.transitionTo(nextState);
            // ③ 继续处理下一个状态
            context.handle();
        }
    }
}
