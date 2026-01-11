package com.example.creational.factory2.abstract_factory;

public class HuaweiFactory implements BrandFactory {

    @Override
    public Phone getPhone() {
        return new HuaweiPhone();
    }

    @Override
    public Computer getComputer() {
        return new HuaweiComputer();
    }

}
