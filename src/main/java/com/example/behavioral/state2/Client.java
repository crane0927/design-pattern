package com.example.behavioral.state2;

/**
 * 客户端示例（改进版）
 * 演示如何在两个状态之间插入新状态，无需修改现有代码
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("=== 原始状态链 ===");
        OrderContext context1 = new OrderContext(new PendingPayState());
        context1.handle();
        
        System.out.println("\n=== 插入新状态后的状态链 ===");
        // 在 PaidState 和 ShippedState 之间插入 ProcessingState
        // 只需要修改状态转换管理器，无需修改现有状态类
        StateTransitionManager.addTransition(PaidState.class, ProcessingState.class);
        StateTransitionManager.addTransition(ProcessingState.class, ShippedState.class);
        
        OrderContext context2 = new OrderContext(new PendingPayState());
        context2.handle();
    }
}
