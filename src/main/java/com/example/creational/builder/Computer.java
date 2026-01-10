package com.example.creational.builder;

/**
 * 计算机类 通过建造着模式构建
 */
public class Computer {

    private String cpu; // 处理器
    private String mainboard; // 主板
    private String memory; // 内存
    private String storage; // 存储
    private String graphicsCard; // 显卡
    private String powerSupply; // 电源
    private String coolingSystem; // 散热系统

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.mainboard = builder.mainboard;
        this.memory = builder.memory;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.powerSupply = builder.powerSupply;
        this.coolingSystem = builder.coolingSystem;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String cpu;
        private String mainboard;
        private String memory;
        private String storage;
        private String graphicsCard;
        private String powerSupply;
        private String coolingSystem;

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }
        
        public Builder mainboard(String mainboard) {
            this.mainboard = mainboard;
            return this;
        }
        
        public Builder memory(String memory) {
            this.memory = memory;
            return this;
        }
        
        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }
        
        public Builder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }
        
        public Builder powerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }
        
        public Builder coolingSystem(String coolingSystem) {
            this.coolingSystem = coolingSystem;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", mainboard='" + mainboard + '\'' +
                ", memory='" + memory + '\'' +
                ", storage='" + storage + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", powerSupply='" + powerSupply + '\'' +
                ", coolingSystem='" + coolingSystem + '\'' +
                '}';
    }

}
