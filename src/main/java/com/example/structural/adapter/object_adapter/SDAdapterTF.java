package com.example.structural.adapter.object_adapter;


/**
 * 对象适配器，通过组合的方式实现适配器模式
 * 适配 TF 卡
 * 让计算机和读取 SD 卡一样的读取 TF 卡
 */
public class SDAdapterTF  implements SDCard {

    private  TFCard tfCard;

    /**
     * 构造函数,只提供有参构造
     * @param tfCard
     */
    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public void read() {
        tfCard.read();
    }

    @Override
    public void write(String data) {
        tfCard.write(data);
    }
}
