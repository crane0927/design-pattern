package com.example.creational.factory2.abstractfactory;

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
