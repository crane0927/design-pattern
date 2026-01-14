package com.example.behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Client {
    public static void main(String[] args) {
        // 使用 ArrayList 的迭代器
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("张三");
        arrayList.add("李四");
        arrayList.add("王五");
        Iterator<String> iterator = arrayList.iterator();
        if (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("=====================");
        // 使用自定义聚合接口的迭代器
        NameRepository nameRepository = new NameRepository();
        Iterator<String> nameIterator = nameRepository.iterator();
        while (nameIterator.hasNext()) {
            System.out.println(nameIterator.next());
        }
    }

}
