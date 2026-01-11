package com.example.structural.adapter.object_adapter;

/**
 * 计算机类,只支持 SD 卡
 */
public class Computer {

    public void readSD(SDCard sdc) {
        sdc.read();
    }

    public void writeSD(SDCard sdc, String data) {
        sdc.write(data);
    }
}
