package com.example.behavioral.state;

public class PaidState implements OrderState {

    @Override
    public void handle(OrderContext context) {
        // ① 执行当前状态的处理逻辑
        System.out.println("已支付状态");
        
        // ② 处理完成后，转换到下一个状态
        context.transitionTo(new ShippedState());
        
        // ③ 继续处理下一个状态
        context.handle();
    }

}
