package com.example.behavioral.responsibility2;

/**
 * 具体处理者：主管（新增处理者）
 * 可以批准 5 天以内的请假
 * 演示如何在责任链中插入新处理者，无需修改现有代码
 */
public class Supervisor extends Approver {

    @Override
    public void approve(int days) {
        if (days <= 5) {
            // 可以处理，直接批准
            System.out.println("Supervisor 批准了 " + days + " 天的请假请求");
        } else {
            // 无法处理，传递给下一个处理者
            if (approver != null) {
                approver.approve(days);
            } else {
                System.out.println("Supervisor 无法处理 " + days + " 天的请假请求");
            }
        }
    }
}
