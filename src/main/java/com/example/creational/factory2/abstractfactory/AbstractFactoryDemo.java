package com.example.creational.factory2.abstractfactory;

/**
 * 抽象工厂方法
 *
 */
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        BrandFactory brandFactory = new AppleFactory();
        Phone phone = brandFactory.getPhone();
        Computer computer = brandFactory.getComputer();
        System.out.println(phone.name() + "   " + computer.name());

        brandFactory = new HuaweiFactory();
        Phone phone2 = brandFactory.getPhone();
        Computer computer2 = brandFactory.getComputer();
        System.out.println(phone2.name() + "   " + computer2.name());
    }
}
