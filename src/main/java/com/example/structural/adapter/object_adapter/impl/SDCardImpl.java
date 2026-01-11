package com.example.structural.adapter.object_adapter.impl;

import com.example.structural.adapter.object_adapter.SDCard;

public class SDCardImpl implements SDCard {

    @Override
    public void read() {
        System.out.println("SDCard read");
    }

    @Override
    public void write(String data) {
        System.out.println("SDCard write: " + data);
    }
}
