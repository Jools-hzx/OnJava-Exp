package com.jools.designpattern.builder.str;

import java.util.Arrays;

/**
 * @author Jools He
 * @date 2025/7/26 23:41
 * @description: TODO
 */
public class AbstractStringBuilder {

    protected char[] value;

    protected int count;


    public AbstractStringBuilder(int capacity) {
        this.count = 0;
        value = new char[capacity];
    }

    public AbstractStringBuilder() {
    }

    public AbstractStringBuilder append(char c) {
        ensureCapacityInternal(count + 1);
        value[count++] = c;
        return this;
    }

    private void ensureCapacityInternal(int minCapacity) {
        // overflow-conscious code
        if (minCapacity - value.length > 0) {
            expandCapacity(minCapacity);
        }
    }

    void expandCapacity(int minimumCapacity) {
        int newCapacity = value.length * 2 + 2;
        if (newCapacity - minimumCapacity < 0) {
            newCapacity = minimumCapacity;
        }
        if (newCapacity < 0) {
            if (minimumCapacity < 0) { // overflow
                throw new OutOfMemoryError();
            }
            newCapacity = Integer.MAX_VALUE;
        }
        value = Arrays.copyOf(value, newCapacity);
    }
}
