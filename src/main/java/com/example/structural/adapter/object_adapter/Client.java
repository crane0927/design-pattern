package com.example.structural.adapter.object_adapter;

import com.example.structural.adapter.object_adapter.impl.SDCardImpl;
import com.example.structural.adapter.object_adapter.impl.TFCardImpl;

public class Client {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.readSD(new SDCardImpl());
        computer.writeSD(new SDCardImpl(), "Hello, World!");

        System.out.println("=====================");

        SDAdapterTF sdAdapterTF = new SDAdapterTF(new TFCardImpl());
        computer.readSD(sdAdapterTF);
        computer.writeSD(sdAdapterTF, "Hello, World!");
    }
}
