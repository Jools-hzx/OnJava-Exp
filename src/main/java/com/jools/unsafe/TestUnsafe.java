package com.jools.unsafe;

import sun.misc.Unsafe;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/1/30 0:25
 * @description: TODO
 */
public class TestUnsafe {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class<?> aClass = Class.forName("jdk.internal.misc.Unsafe");
        Unsafe unsafe = (Unsafe) aClass.newInstance();

        System.out.println(unsafe);
    }
}
