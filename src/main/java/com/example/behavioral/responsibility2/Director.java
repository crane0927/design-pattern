package com.example.behavioral.responsibility2;

/**
 * 具体处理者：总监
 * 可以批准 10 天以内的请假，超过 10 天拒绝
 */
public class Director extends Approver {

    @Override
    public void approve(int days) {
        if (days <= 10) {
            // 可以处理，直接批准
            System.out.println("Director 批准了 " + days + " 天的请假请求");
        } else {
            // 无法处理，拒绝（责任链的末端）
            System.out.println("Director 拒绝了 " + days + " 天的请假请求");
        }
    }
}
