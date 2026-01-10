package com.example.creational.factory2.abstractfactory;

public class AppleFactory implements BrandFactory {

    @Override
    public Phone getPhone() {
        return new ApplePhone();
    }

    @Override
    public Computer getComputer() {
        return new AppleComputer();
    }

}
