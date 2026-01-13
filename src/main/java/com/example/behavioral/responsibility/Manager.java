package com.example.behavioral.responsibility;
/**
 * 具体处理者 
 */
public class Manager extends Approver {

    @Override
    public void approve(int days) {
        if (days <= 7) {
            System.out.println("Manager 批准了 " + days + " 天的请假请求");
        } else {
            if (approver != null) {
                approver.approve(days);
            } else {
                System.out.println("Manager 无法处理 " + days + " 天的请假请求");
            }
        }
    }

}
