package com.example.behavioral.interpreter;

/**
 * 非终结符表达式(加法表达式)
 */
public class AddExpression implements Expression {

    private Expression left; // 左表达式
    private Expression right; // 右表达式

    public AddExpression(Expression left, Expression right) { // 初始化左表达式和右表达式
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) + right.interpret(context); // 解释表达式
    }
}
