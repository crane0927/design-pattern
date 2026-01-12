package com.example.behavioral.template;

public class Deposit extends BankingBusiness {

    @Override
    protected void handleBusiness() {
        System.out.println("存款");
    }

}
