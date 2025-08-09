package com.jools.xiaohui.algorithm;

import java.util.Objects;
import java.util.Stack;

/**
 * @author Jools He
 * @date 2025/8/9 17:08
 * @description: TODO
 */
public class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    // 入栈操作
    public void push(int x) {
        if(minStack.isEmpty() || x < minStack.peek()) {
            minStack.push(x);
        }
        stack.push(x);
    }

    public int pop() {
        if(stack.isEmpty()) {
            return -1;
        }
        if(Objects.equals(stack.peek(), minStack.peek())) {
            minStack.pop();
        }
        return stack.pop();
    }

    public int getMin() {
        if(minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack mStack = new MinStack();
        mStack.push(4);
        mStack.push(9);
        mStack.push(7);
        mStack.push(3);
        mStack.push(8);
        mStack.push(5);
        System.out.println(mStack.getMin());    // 3
        mStack.pop();    // 5
        mStack.pop();    // 8
        mStack.pop();    // 3
        System.out.println(mStack.getMin());    // 4
    }
}
