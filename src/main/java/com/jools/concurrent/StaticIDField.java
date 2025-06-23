package com.jools.concurrent;

/**
 * @author Jools He
 * @date 2025/6/19 21:24
 * @description: TODO
 */
public class StaticIDField implements HasID {

    private static int counter = 0;
    private int id = counter++;

    @Override
    public int getID() {
        return 0;
    }
}
