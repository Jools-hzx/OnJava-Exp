package com.jools.reflection_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/11 21:31
 * @description: TODO
 */
public class GenericClassReferences {

    public static void main(String[] args) {
        Class<Integer> intCls = int.class;
        Class<Double> doubleCls = double.class;
        Class<Integer> genericCls = int.class;
        genericCls = Integer.class; // 通过
//        genericCls = double.class; // 报错
    }
}
