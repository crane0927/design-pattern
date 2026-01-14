    package com.example.behavioral.interpreter;

/**
 * 客户端
 */
public class Client {

    public static void main(String[] args) {
        Context context = new Context();
        context.setVariable("a", 10);
        context.setVariable("b", 20);
        context.setVariable("c", 30);

        // 表达式 1: a + b
        Expression expression = new AddExpression(new VariableExpression("a"), new VariableExpression("b"));
        System.out.println(expression.interpret(context)); // 解释表达式
        System.out.println("=====================");
        // 表达式 2: a - b
        expression = new SubtractExpression(new VariableExpression("a"), new VariableExpression("b"));
        System.out.println(expression.interpret(context)); // 解释表达式
        System.out.println("=====================");
        // 表达式 3: a + (b - c)
        expression = new AddExpression(new VariableExpression("a"), new SubtractExpression(new VariableExpression("b"), new VariableExpression("c")));
        System.out.println(expression.interpret(context)); // 解释表达式
    }

}
