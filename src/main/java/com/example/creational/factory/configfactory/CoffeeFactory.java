package com.example.creational.factory.configfactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class CoffeeFactory {

    private static HashMap<String, Coffee> map = new HashMap<>();

    static {
        Properties properties = new Properties();
        InputStream resourceAsStream = CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            // 加载 bean.properties 配置文件，存入 map
            properties.load(resourceAsStream);
            Set<Object> keySet = properties.keySet();
            for (Object key : keySet) {
                String className = properties.getProperty((String) key);
                try {
                    Class<?> clazz = Class.forName(className);
                    Coffee coffee = (Coffee) clazz.getDeclaredConstructor().newInstance();
                    map.put((String) key, coffee);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Coffee getCoffee(String type) {
        return map.get(type);
    }

}
