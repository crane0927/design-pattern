package com.example.structural.adapter.class_adapter;

import com.example.structural.adapter.class_adapter.impl.SDCardImpl;

public class Client {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.readSD(new SDCardImpl());
        computer.writeSD(new SDCardImpl(), "Hello, World!");

        System.out.println("=====================");

        computer.readSD(new SDAdapterTF());
        computer.writeSD(new SDAdapterTF(), "Hello, World!");
    }
}
