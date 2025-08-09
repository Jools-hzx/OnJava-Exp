package com.jools.designpattern.interpreter;

/**
 * @author Jools He
 * @date 2025/7/30 3:57
 * @description: TODO
 */
public class RepeatCommandNode extends Node {

    private int number;

    private Node commandListNode;

    @Override
    public void parse(Context context) throws Exception {
        number = context.currentNumber();
        context.skipToken("repeat");
        context.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public String toString() {
        return "[" +
                "repeat=" + number +
                ", commandListNode=" + commandListNode +
                ']';
    }
}
