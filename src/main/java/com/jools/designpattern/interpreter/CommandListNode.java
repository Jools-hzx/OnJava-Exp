package com.jools.designpattern.interpreter;

import java.util.ArrayList;

/**
 * @author Jools He
 * @date 2025/7/30 3:43
 * @description: TODO
 */
public class CommandListNode extends Node {

    private ArrayList<Node> commandList = new ArrayList<>();

    @Override
    public void parse(Context context) throws Exception {
        while (true) {
            if (context.currentToken() == null) {
                throw new ParseException("Missing 'end'");
            } else if (context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            } else {
                Node commandNode = new CommandNode();
                commandNode.parse(context);
                commandList.add(commandNode);
            }
        }
    }

    @Override
    public String toString() {
        return commandList.toString();
    }
}
