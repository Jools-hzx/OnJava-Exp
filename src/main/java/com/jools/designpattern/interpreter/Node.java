package com.jools.designpattern.interpreter;

/**
 * @author Jools He
 * @date 2025/7/30 3:32
 * @description: TODO
 */
public abstract class Node {
    public abstract void parse(Context context) throws Exception;
}
