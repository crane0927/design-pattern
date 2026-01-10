package com.example.factory2.staticfactory;

/**
 * 静态工厂
 * 通过一个工厂类来创建对象，但是工厂和具体产品类之间违反开闭原则
 *
 */
public class StaticFactoryDemo {

    public static void main(String[] args) {
        StoreService storeService = new StoreService();
        Phone phone = storeService.get("apple");
        System.out.println(phone.name());
        Phone phone2 = storeService.get("huawei");
        System.out.println(phone2.name());
    }
}
