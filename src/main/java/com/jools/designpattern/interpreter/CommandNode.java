package com.jools.designpattern.interpreter;

/**
 * @author Jools He
 * @date 2025/7/30 3:54
 * @description: TODO
 */
public class CommandNode extends Node{

    private Node node;

    @Override
    public void parse(Context context) throws Exception {
        if (context.currentToken().equals("repeat")) {
            node = new RepeatCommandNode();
            node.parse(context);
        } else {
            node = new PrimitiveCommandNode();
            node.parse(context);
        }
    }

    @Override
    public String toString() {
        return node.toString();
    }
}
