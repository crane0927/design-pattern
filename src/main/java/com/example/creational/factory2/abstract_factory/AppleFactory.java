package com.example.creational.factory2.abstract_factory;

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
