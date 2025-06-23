package com.jools.assertion;

import java.util.Arrays;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/5 22:19
 * @description: TODO
 */
public class CircularQueue {

    private Object[] data;

    // 下一个可用存储的空间; 下一个可以获取的对象
    private int in = 0, out = 0;

    // 是否已经回到了循环队列的开头
    private boolean wrapped = false;

    public CircularQueue(Object[] data) {
        this.data = data;
        assert true;
    }

    // 判断是否为空
    public boolean empty() {
        return !wrapped && in == out;
    }

    // 是否已满
    public boolean full() {
        return wrapped && in == out;
    }

    public boolean isWrapped() {
        return this.wrapped;
    }

    public Object get() {
        precondition(!empty(), "get() from empty Circular Queue");
        // 校验无 Null 存在于 data
        assert invariant();
        Object returnVal = data[out];
        data[out] = null;
        out++;
        if (out >= data.length) {
            out = 0;
            wrapped = false;
        }
        // 校验不能为空
        assert postcondition(returnVal != null, "Null item in CircularQueue");
        assert invariant();
        return returnVal;
    }

    // 契约式设计的相关方法
    // 前置检查
    private static void precondition(boolean cond, String msg) {
        if (!cond) {
            throw new CircularQueueException(msg);
        }
    }

    private static boolean postcondition(boolean cond, String msg) {
        if (!cond) {
            throw new CircularQueueException(msg);
        }
        return true;
    }

    private boolean invariant() {
        // 保证在保存了对象的 data 区域不会有空值
        for (int i = out; i != in; i = (i + 1) % data.length) {
            if (data[i] == null) {
                throw new CircularQueueException("Null in CircularQueue");
            }
        }
        // 保证在保存了对象的 data 区域之外会有空值
        if (full()) return true;
        for (int i = in; i != out; i = (i + 1) % data.length) {
            if (data[i] != null) {
                throw new CircularQueueException(
                        "non-null outside of CircularQueue range:" + dump());
            }
        }
        return true;
    }

    public String dump() {
        StringBuilder sb = new StringBuilder();
        sb.append("in = ").append(this.in)
                .append(", full() = ").append(this.full())
                .append(", empty() = ").append(empty())
                .append(", CircularQueue = ").append(Arrays.asList(data));
        return sb.toString();
    }
}

