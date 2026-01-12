package com.example.behavioral.template;

public class Withdrawal extends BankingBusiness {

    @Override
    protected void handleBusiness() {
        System.out.println("取款");
    }

}
