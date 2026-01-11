package com.example.structural.adapter.class_adapter;

import com.example.structural.adapter.class_adapter.impl.TFCardImpl;

/**
 * 类适配器，通过继承的方式实现适配器模式
 * 适配 TF 卡
 * 让计算机和读取 SD 卡一样的读取 TF 卡 违反合成复用原则
 */
public class SDAdapterTF extends TFCardImpl implements SDCard {

    @Override
    public void read() {
        super.read();
    }

    @Override
    public void write(String data) {
        super.write(data);
    }
}
