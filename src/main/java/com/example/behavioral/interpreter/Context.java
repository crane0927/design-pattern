package com.example.behavioral.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文
 */
public class Context {

    private Map<String, Integer> variables = new HashMap<>(); // 变量表

    public void setVariable(String name, int value) { // 设置变量
        variables.put(name, value);
    }

    public int getVariable(String name) { // 获取变量
        return variables.get(name);
    }

}
