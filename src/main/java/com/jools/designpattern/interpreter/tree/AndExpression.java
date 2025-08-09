package com.jools.designpattern.interpreter.tree;

/**
 * @author Jools He
 * @date 2025/8/2 16:57
 * @description: TODO
 */
public class AndExpression extends Expression {

    private Expression exp1;
    private Expression exp2;

    public AndExpression(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public boolean interpret(String str) {
        // 具体 interpret 操作; 实现 && 运算
        return exp1.interpret(str) && exp2.interpret(str);
    }
}
