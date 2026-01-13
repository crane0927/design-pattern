package com.example.behavioral.responsibility2;

/**
 * 客户端示例（改进版）
 * 演示如何在责任链中插入新处理者，无需修改现有代码
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("=== 原始责任链 ===");
        Approver chain1 = ChainManager.buildChain();
        if (chain1 != null) {
            chain1.approve(1);
            chain1.approve(3);
            chain1.approve(7);
            chain1.approve(10);
            chain1.approve(20);
        }
        
        System.out.println("\n=== 插入新处理者后的责任链 ===");
        // 清空原有配置，重新构建责任链
        ChainManager.clearChain();
        ChainManager.addApprover(Manager.class);
        ChainManager.addApprover(Supervisor.class); // 插入 Supervisor
        ChainManager.addApprover(Leader.class);
        ChainManager.addApprover(Director.class);
        
        Approver chain2 = ChainManager.buildChain();
        if (chain2 != null) {
            chain2.approve(1);
            chain2.approve(3);
            chain2.approve(5);
            chain2.approve(7);
            chain2.approve(10);
            chain2.approve(20);
        }
    }
}
