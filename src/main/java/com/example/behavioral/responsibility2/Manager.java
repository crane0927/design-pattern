package com.example.behavioral.responsibility2;

/**
 * 具体处理者：经理
 * 可以批准 7 天以内的请假
 */
public class Manager extends Approver {

    @Override
    public void approve(int days) {
        // Manager 处理 6-7 天的请假（5天及以下由 Supervisor 处理）
        if (days > 5 && days <= 7) {
            // 可以处理，直接批准
            System.out.println("Manager 批准了 " + days + " 天的请假请求");
        } else {
            // 无法处理，传递给下一个处理者
            if (approver != null) {
                approver.approve(days);
            } else {
                System.out.println("Manager 无法处理 " + days + " 天的请假请求");
            }
        }
    }
}
