package com.example.factory2.method;

public class StoreService {

    private final PhoneFactory phoneFactory;

    public StoreService(PhoneFactory phoneFactory) {
        this.phoneFactory = phoneFactory;
    }

    public Phone get() {
        return phoneFactory.get();
    }

}
