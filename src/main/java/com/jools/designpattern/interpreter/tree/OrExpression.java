package com.jools.designpattern.interpreter.tree;

/**
 * @author Jools He
 * @date 2025/8/2 16:59
 * @description: TODO
 */
public class OrExpression extends Expression{

    private Expression exp1 = null;
    private Expression exp2 = null;

    public OrExpression(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    // 具体实现解释操作 - 逻辑或
    @Override
    public boolean interpret(String str) {
        return exp1.interpret(str) || exp2.interpret(str);
    }
}
