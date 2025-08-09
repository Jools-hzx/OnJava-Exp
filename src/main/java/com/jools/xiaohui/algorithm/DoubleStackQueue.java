package com.jools.xiaohui.algorithm;

import java.util.Stack;

/**
 * @author Jools He
 * @date 2025/8/9 20:14
 * @description: TODO
 */
public class DoubleStackQueue {

    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    /**
     * 入队操作
     *
     * @param element 入队元素
     */
    public void enQueue(int element) {
        stackA.push(element);
    }

    /**
     * 出队操作
     */
    public Integer deQueue() {
        if (stackB.isEmpty()) {
            // 如果入队栈此时也为空，说明队列空
            if (stackA.isEmpty()) {
                return null;
            }
            // 否则将当前入队栈内元素全部出栈并压入入队栈
            transfer();
        }
        return stackB.pop();
    }

    // 将入队栈的元素压入到出队栈
    private void transfer() {
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
    }
}
