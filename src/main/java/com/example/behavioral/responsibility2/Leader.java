package com.example.behavioral.responsibility2;

/**
 * 具体处理者：组长
 * 可以批准 3 天以内的请假
 */
public class Leader extends Approver {

    @Override
    public void approve(int days) {
        if (days <= 3) {
            // 可以处理，直接批准
            System.out.println("Leader 批准了 " + days + " 天的请假请求");
        } else {
            // 无法处理，传递给下一个处理者
            if (approver != null) {
                approver.approve(days);
            } else {
                System.out.println("Leader 无法处理 " + days + " 天的请假请求");
            }
        }
    }
}
