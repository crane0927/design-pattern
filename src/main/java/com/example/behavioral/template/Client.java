package com.example.behavioral.template;

public class Client {

    public static void main(String[] args) {
        BankingBusiness deposit = new Deposit();
        deposit.process();
        System.out.println("=====================");
        BankingBusiness withdrawal = new Withdrawal();
        withdrawal.process();
    }

}
