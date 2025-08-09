package com.jools.designpattern.interpreter.tree;

/**
 * @author Jools He
 * @date 2025/8/2 17:04
 * @description: TODO
 */
public class Client {

    /**
     * 构建解析树
     */
    public static Expression buildInterpreterTree() {
        // Literal
        TerminalExpression terminal_01 = new TerminalExpression("A");
        TerminalExpression terminal_02 = new TerminalExpression("B");
        TerminalExpression terminal_03 = new TerminalExpression("C");
        TerminalExpression terminal_04 = new TerminalExpression("D");

        // 构建 B or C
        Expression alternation1 = new OrExpression(terminal_02, terminal_03);
        // A Or (B OR C)
        Expression alterantion2 = new OrExpression(terminal_01, alternation1);
        // 构建 D AND (A OR (B OR C))
        return new AndExpression(terminal_04, alterantion2);
    }

    // 测试解释器执行
    public static void main(String[] args) {
        Expression define = buildInterpreterTree();
        String context1 = "D A";
        String context2 = "A B";
        System.out.println(define.interpret(context1)); // 输出 true
        System.out.println(define.interpret(context2)); // 输出 false
    }
}
