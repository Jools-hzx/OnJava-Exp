package com.jools.designpattern.builder.str;

/**
 * @author Jools He
 * @date 2025/7/26 23:46
 * @description: TODO
 */
public class StringBuilder extends AbstractStringBuilder {

    public StringBuilder() {
        super(16);
    }

    @Override
    public String toString() {
        // Create a copy, don't share the array
        return new String(value, 0, count);
    }
}
