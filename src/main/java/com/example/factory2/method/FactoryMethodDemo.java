package com.example.factory2.method;

/**
 * 工厂方法
 * 符合开闭原则
 *
 */
public class FactoryMethodDemo {

    public static void main(String[] args) {
        StoreService storeService = new StoreService(new ApplePhoneFactory());
        Phone phone = storeService.get();
        System.out.println(phone.name());
        storeService = new StoreService(new HuaweiPhoneFactory());
        Phone phone2 = storeService.get();
        System.out.println(phone2.name());
    }
}
