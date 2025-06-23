package com.jools.generic_;

import java.util.ArrayList;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/19 16:46
 * @description: TODO
 */
public class ErasedTypeEquivalence {

    public static void main(String[] args) {
        Class<?> c1 = new ArrayList<String>().getClass();
        Class<?> c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);   // true
    }
}
