package com.jools.designpattern.interpreter.tree;

import java.util.StringTokenizer;

/**
 * @author Jools He
 * @description: TODO
 */
public class TerminalExpression extends Expression{

    private String literal = null;

    public TerminalExpression(String str) {
        this.literal = str;
    }

    @Override
    public boolean interpret(String str) {
        StringTokenizer st = new StringTokenizer(str);
        while(st.hasMoreTokens()) {
            String test = st.nextToken();
            if(test.equals(literal)) {  // 匹配到目标 literal
                return true;
            }
        }
        return false;
    }
}
