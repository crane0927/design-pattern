package com.example.factory2.simple;

public class PhoneFactory {

    public Phone get(String type) {
        if ("apple".equalsIgnoreCase(type)) {
            return new ApplePhone();
        } else if ("huawei".equalsIgnoreCase(type)) {
            return new HuaweiPhone();
        }
        throw new IllegalArgumentException("未知手机类型");
    }

}
