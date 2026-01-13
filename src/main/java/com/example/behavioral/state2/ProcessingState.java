package com.example.behavioral.state2;

/**
 * 处理中状态（新增状态）
 * 演示如何在两个状态之间插入新状态，无需修改现有代码
 */
public class ProcessingState implements OrderState {

    @Override
    public void handle(OrderContext context) {
        // ① 执行当前状态的处理逻辑
        System.out.println("处理中状态");
        
        // ② 使用状态转换管理器获取下一个状态
        OrderState nextState = StateTransitionManager.getNextState(this.getClass());
        if (nextState != null) {
            context.transitionTo(nextState);
            // ③ 继续处理下一个状态
            context.handle();
        }
    }
}
