package com.example.behavioral.responsibility;

public class Client {

    public static void main(String[] args) {
        Manager manager = new Manager();
        Leader leader = new Leader();
        Director director = new Director();

         //  设置责任链
        manager.setNext(leader);
        leader.setNext(director);
        manager.approve(1);
        manager.approve(3);
        manager.approve(7);
        manager.approve(10);
        manager.approve(20);
    }
}
