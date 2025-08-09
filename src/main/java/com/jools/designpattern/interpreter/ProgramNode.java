package com.jools.designpattern.interpreter;

/**
 * @author Jools He
 * @date 2025/7/30 3:41
 * @description: TODO
 */
public class ProgramNode extends Node{

    private Node commandListNode;

    @Override
    public void parse(Context context) throws Exception {
        context.skipToken("program");
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public String toString() {
        return "[" +
                "commandListNode=" + commandListNode +
                ']';
    }
}
