package com.example.factory2.simple;

public class StoreService {

    private final PhoneFactory factory = new PhoneFactory();

    public Phone get(String type) {
        return factory.get(type);
    }

}
