package com.jools.annotation_;

import java.util.LinkedList;

/**
 * @author Jools He
 * @date 2025/6/17 17:24
 * @description: TODO
 */
public class StackGeneric_<T> {

    private LinkedList<T> list = new LinkedList<>();

    public void push(T v) {
        list.addFirst(v);
    }

    public T peek() {
        return list.getFirst();
    }

    public T pop() {
        return list.removeFirst();
    }
}
