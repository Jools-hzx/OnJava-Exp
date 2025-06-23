package com.jools.reflection_;

import org.junit.jupiter.api.Test;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/11 21:41
 * @description: TODO
 */
public class WildcardClassReferences {

    public static void main(String[] args) {
        Class<?> intCls = int.class;
        intCls = double.class;
    }

    @Test
    public void boundedClassRefer() {
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
    }
}
