package com.jools.designpattern.interpreter;

/**
 * @author Jools He
 * @date 2025/7/30 3:58
 * @description: TODO
 */
public class PrimitiveCommandNode extends Node{

    private String name;

    @Override
    public void parse(Context context) throws Exception {
        name = context.currentToken();
        context.skipToken(name);
        if(!name.equals("go") && !name.equals("right") && !name.equals("left")) {
            throw new ParseException(name + " is undefined");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
