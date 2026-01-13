package com.example.behavioral.responsibility;

/**
 * 具体处理者
 */
public class Director extends Approver {

    @Override
    public void approve(int days) {
        if (days <= 10) {
            System.out.println("Director 批准了 " + days + " 天的请假请求");
        } else {
            System.out.println("Director 拒绝了 " + days + " 天的请假请求");
        }
    }
}
