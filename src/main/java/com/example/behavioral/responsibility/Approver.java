package com.example.behavioral.responsibility;
/**
 * 抽象处理者
 */
public abstract class Approver {
    
    protected Approver approver; // 自己是自己的属性

    public void setNext(Approver approver) {  // 设置下一个处理者
        this.approver = approver;
    }

    public abstract void approve(int days); // 处理请假请求

}
