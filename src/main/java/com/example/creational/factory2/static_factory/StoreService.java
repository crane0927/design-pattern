package com.example.creational.factory2.static_factory;

public class StoreService {

    public Phone get(String type) {
        return PhoneFactory.get(type);
    }

}
