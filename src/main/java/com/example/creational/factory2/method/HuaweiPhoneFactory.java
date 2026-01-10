package com.example.creational.factory2.method;

public class HuaweiPhoneFactory implements PhoneFactory {

    @Override
    public Phone get() {
        return new HuaweiPhone();
    }

}
