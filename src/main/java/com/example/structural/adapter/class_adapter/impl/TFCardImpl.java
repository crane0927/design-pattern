package com.example.structural.adapter.class_adapter.impl;

import com.example.structural.adapter.class_adapter.TFCard;

public class TFCardImpl implements TFCard {

    @Override
    public void read() {
        System.out.println("TFCard read");
    }

    @Override
    public void write(String data) {
        System.out.println("TFCard write: " + data);
    }
}
