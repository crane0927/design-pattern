package com.example.structural.flyweight;

import java.util.HashMap;

/**
 * 俄罗斯方块游戏中的方块工厂类
 */
public class BoxFactory {

    private static HashMap<String, AbstractBox> map = new HashMap<>();
    static {
        map.put("I", new IBox());
        map.put("J", new JBox());
        map.put("L", new LBox());
        // map.put("O", new OBox());
        // map.put("S", new SBox());
        // map.put("T", new TBox());
        // map.put("Z", new ZBox());
    }

    public static AbstractBox getBox(String key) {
        return map.get(key);
    }

    private static final BoxFactory instance = new BoxFactory();
    
    private BoxFactory() {
    }
    public static BoxFactory getInstance() {
        return instance;
    }
}
