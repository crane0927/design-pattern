package com.example.behavioral.interpreter;

/**
 * 终结符表达式(变量表达式)
 */
public class VariableExpression implements Expression {

    private String name; // 变量名

    public VariableExpression(String name) { // 初始化变量名
        this.name = name;
    }

    @Override
    public int interpret(Context context) {
        return context.getVariable(name); // 获取变量值
    }
}
