package com.example.creational.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        Computer computer = Computer.builder()
        .cpu("Intel Core i7-11700K")
        .mainboard("ASUS ROG STRIX Z690-A GAMING WIFI")
        .memory("16GB DDR4 3200MHz")
        .storage("1TB SSD")
        .graphicsCard("NVIDIA GeForce RTX 3080")
        .powerSupply("Corsair RM850x")
        .coolingSystem("Noctua NH-D15")
        .build();
        System.out.println(computer);
    }

}
