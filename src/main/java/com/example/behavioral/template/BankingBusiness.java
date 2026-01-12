package com.example.behavioral.template;

/**
 * 银行业务抽象类
 */
public abstract class BankingBusiness {

    public final void process() { // 定义为 final 方法，防止子类重写
        takeNumber();
        waitInLine();
        handleBusiness();
        evaluate();
    }

    protected void takeNumber() {
        System.out.println("取号");
    } 

    protected void waitInLine() {
        System.out.println("等待叫号");
    } 

    protected abstract void handleBusiness(); // 办理业务

    protected void evaluate() {
        System.out.println("评价");
    } 

}
