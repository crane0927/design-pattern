package com.example.creational.factory2.direct;

/**
 * 直接获取，不使用工厂
 * 违反开闭原则
 */
public class DirectDemo {

    public static void main(String[] args) {
        StoreService storeService = new StoreService();
        Phone phone = storeService.get("apple");
        System.out.println(phone.name());
        Phone phone2 = storeService.get("huawei");
        System.out.println(phone2.name());
    }
}
