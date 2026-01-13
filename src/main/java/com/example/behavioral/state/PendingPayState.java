package com.example.behavioral.state;

public class PendingPayState implements OrderState {

    @Override
    public void handle(OrderContext context) {
        // ① 执行当前状态的处理逻辑
        System.out.println("待支付状态");
        
        // ② 处理完成后，转换到下一个状态
        context.transitionTo(new PaidState());
        
        // ③ 继续处理下一个状态
        context.handle();
    }

}
