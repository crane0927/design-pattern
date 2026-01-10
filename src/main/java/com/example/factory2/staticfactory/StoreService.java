package com.example.factory2.staticfactory;

public class StoreService {

    public Phone get(String type) {
        return PhoneFactory.get(type);
    }

}
