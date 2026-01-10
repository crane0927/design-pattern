package com.example.factory2.method;

public class ApplePhoneFactory implements PhoneFactory {

    @Override
    public Phone get() {
        return new ApplePhone();
    }

}
