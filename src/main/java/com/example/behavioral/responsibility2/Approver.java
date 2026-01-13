package com.example.behavioral.responsibility2;

/**
 * 抽象处理者
 */
public abstract class Approver {
    
    protected Approver approver; // 下一个处理者

    /**
     * 设置下一个处理者
     * @param approver 下一个处理者
     */
    public void setNext(Approver approver) {
        this.approver = approver;
    }

    /**
     * 处理请假请求
     * @param days 请假天数
     */
    public abstract void approve(int days);

}
