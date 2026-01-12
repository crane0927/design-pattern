package com.example.structural.facade;

public class Computer {

    private Cpu cpu;
    private Memory memory;
    private Motherboard motherboard;

    public Computer() {
        this.cpu = new Cpu();
        this.memory = new Memory();
        this.motherboard = new Motherboard();
    }

    /**
     * 此处违反开闭原则，如果需要新增组件，需要修改 Computer 类
     */
    public void start() {
        System.out.println("计算机启动");
        cpu.start();
        memory.start();
        motherboard.start();
    }

    public void shutdown() {

        cpu.shutdown();
        memory.shutdown();
        motherboard.shutdown();
        System.out.println("计算机关闭");
    }
}
